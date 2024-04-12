package alessia.Compito.settimanale.Gestione.dispositivi.services;

import alessia.Compito.settimanale.Gestione.dispositivi.payloads.PayloadEmployee;
import alessia.Compito.settimanale.Gestione.dispositivi.entities.Employee;
import alessia.Compito.settimanale.Gestione.dispositivi.exceptions.NotFoundException;
import alessia.Compito.settimanale.Gestione.dispositivi.repositories.EmployeeDAO;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    public Page<Employee> getAllEmployees(int page, int size, String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.employeeDAO.findAll(pageable);
    }

    public Employee saveEmployee(PayloadEmployee body){
        Employee newEmployee = new Employee(body.username(),body.name(), body.surname(), body.eMail(), "https://ui-avatars.com/api/?name="+ body.name() + "+" + body.surname(), new ArrayList<>());
        return this.employeeDAO.save(newEmployee);
    }

    public Employee findEmployeeById(int id){
        return employeeDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Employee findEmployeeByIdAndUpdate(int id, Employee updatedBody){
        Optional<Employee> optionalEmployee = employeeDAO.findById(id);

        if (optionalEmployee.isPresent()){
            Employee found = optionalEmployee.get();
            found.setUsername(updatedBody.getUsername());
            found.setName(updatedBody.getName());
            found.setSurname(updatedBody.getSurname());
            found.setEMail(updatedBody.getEMail());

            return this.employeeDAO.save(found);
        }else {
            throw new NotFoundException(id);
        }
    }

    public void findEmployeeByIdAndDelete(int id){
        Optional<Employee> optionalEmployee = employeeDAO.findById(id);

        if (optionalEmployee.isPresent()){
            Employee found = optionalEmployee.get();
            this.employeeDAO.delete(found);
        }else{
            throw new NotFoundException(id);
        }
    }
}

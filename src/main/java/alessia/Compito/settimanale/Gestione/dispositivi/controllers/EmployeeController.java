package alessia.Compito.settimanale.Gestione.dispositivi.controllers;

import alessia.Compito.settimanale.Gestione.dispositivi.entities.Employee;
import alessia.Compito.settimanale.Gestione.dispositivi.exceptions.BadRequestException;
import alessia.Compito.settimanale.Gestione.dispositivi.payloads.NewEmployeeResponse;
import alessia.Compito.settimanale.Gestione.dispositivi.payloads.PayloadEmployee;
import alessia.Compito.settimanale.Gestione.dispositivi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
        public List<Employee> getAllEmployees(){
        return this.employeeService.getAllEmployees();
}


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    private NewEmployeeResponse saveEmployee(@RequestBody @Validated PayloadEmployee body, BindingResult validation){
        if (validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        }
          return  new NewEmployeeResponse(this.employeeService.saveEmployee(body).getId());
    }

    @GetMapping("/{employeeId}")
    private Employee getSingleEmployee(@PathVariable int employeeId){
        return this.employeeService.findEmployeeById(employeeId);
    }

    @PutMapping("/{employeeId}")
    private Employee findSingleEmployeeAndUpdate(@PathVariable int employeeId, @RequestBody Employee body){
        return this.employeeService.findEmployeeByIdAndUpdate(employeeId, body);
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteEmployee(@PathVariable int employeeId){
        this.employeeService.findEmployeeByIdAndDelete(employeeId);
    }


}

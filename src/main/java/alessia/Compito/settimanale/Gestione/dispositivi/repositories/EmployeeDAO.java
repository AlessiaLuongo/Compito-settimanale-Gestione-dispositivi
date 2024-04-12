package alessia.Compito.settimanale.Gestione.dispositivi.repositories;

import alessia.Compito.settimanale.Gestione.dispositivi.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
}

package pl.lanshela.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lanshela.crm.model.Employee;

@Repository(value = "employee_repository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

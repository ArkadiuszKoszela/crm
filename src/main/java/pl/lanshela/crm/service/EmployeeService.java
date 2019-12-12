package pl.lanshela.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lanshela.crm.model.Employee;
import pl.lanshela.crm.repository.*;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private UserDataRepository userDataRepository;
    private PersonalDataRepository personalDataRepository;
    private TaskRepository taskRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, UserDataRepository userDataRepository, PersonalDataRepository personalDataRepository, TaskRepository taskRepository) {
        this.employeeRepository = Objects.requireNonNull(employeeRepository, "Employee repository not found. It must be included.");
        this.userDataRepository = Objects.requireNonNull(userDataRepository, "User Data repository not found. It must be included.");
        this.personalDataRepository = Objects.requireNonNull(personalDataRepository, "Personal Data repository not found. It must be included.");
        this.taskRepository = Objects.requireNonNull(taskRepository, "Task repository not found. It must be included");
    }

    public void save(Employee employee) {
        userDataRepository.save(employee.getUserData());
        personalDataRepository.save(employee.getPersonalData());
        employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long leaderId) {
        return employeeRepository.findById(leaderId).get();
    }
}

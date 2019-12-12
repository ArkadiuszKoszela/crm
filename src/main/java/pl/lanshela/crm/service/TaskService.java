package pl.lanshela.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lanshela.crm.model.Task;
import pl.lanshela.crm.repository.EmployeeRepository;
import pl.lanshela.crm.repository.TaskRepository;

import java.util.List;
import java.util.Objects;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, EmployeeRepository employeeRepository) {
        this.taskRepository = Objects.requireNonNull(taskRepository, "Task repository not found. It must be included. ");
        this.employeeRepository = Objects.requireNonNull(employeeRepository, "Employee repository not found. It must be included. ");
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }
}

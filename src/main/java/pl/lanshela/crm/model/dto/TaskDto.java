package pl.lanshela.crm.model.dto;

import pl.lanshela.crm.model.Employee;
import pl.lanshela.crm.model.TaskStatus;

import java.util.List;

public class TaskDto {

    private String name;
    private String description;
    private Long leaderId;
    private List<Employee> employees;
    private TaskStatus taskStatus;

    public TaskDto() {
    }

    public TaskDto(List<Employee> availableEmployees) {
        this.employees = availableEmployees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}

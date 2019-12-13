package pl.lanshela.crm.model.dto;

import pl.lanshela.crm.model.Employee;
import pl.lanshela.crm.model.TaskStatus;

import java.util.List;

public class TaskDto {

    private String name;
    private String description;
    private Long leaderId;
    private List<Employee> employees;
    private List<TaskStatus> taskStatuses;
    private Long taskStatusId;

    public TaskDto() {
    }

    public TaskDto(List<Employee> employees, List<TaskStatus> taskStatuses) {
        this.employees = employees;
        this.taskStatuses = taskStatuses;
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

    public List<TaskStatus> getTaskStatuses() {
        return taskStatuses;
    }

    public void setTaskStatuses(List<TaskStatus> taskStatuses) {
        this.taskStatuses = taskStatuses;
    }

    public Long getTaskStatusId() {
        return taskStatusId;
    }

    public void setTaskStatusId(Long taskStatusId) {
        this.taskStatusId = taskStatusId;
    }


}

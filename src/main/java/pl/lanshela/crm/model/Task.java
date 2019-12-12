package pl.lanshela.crm.model;

import pl.lanshela.crm.model.dto.TaskDto;

import javax.persistence.*;

@Entity(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;
    private String name;
    private String description;

//   TODO: Like in employee - he can only be a leader.
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "employees_tasks",
//            joinColumns = {@JoinColumn(name = "task_fk")},
//            inverseJoinColumns = {@JoinColumn(name = "employee_fk")})
//    private List<Employee> employees;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee leader;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "task_status_id")
    @Column(name = "task_status")
    private TaskStatus taskStatus;


    public Task() {
    }

    public Task(TaskDto taskDto) {
        this.name = taskDto.getName();
        this.description = taskDto.getDescription();
        this.taskStatus = taskDto.getTaskStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Task)) return false;
        return id != null && id.equals(((Task) obj).getId());
    }
}

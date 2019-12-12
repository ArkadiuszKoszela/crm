package pl.lanshela.crm.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_data_id")
    private UserData userData;
    @OneToOne
    @JoinColumn(name = "personal_data_id")
    private PersonalData personalData;

    //TODO: Tasks assigned to one employee - right now he can only be a leader of a task.
    //    @ManyToMany(mappedBy = "employees")
    //    private List<Task> tasks;

    @OneToMany(mappedBy = "consultant",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Client> clients;

    @OneToMany(mappedBy = "leader",
            cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Task> leaderTasks;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Task> getLeaderTasks() {
        return leaderTasks;
    }

    public void setLeaderTasks(List<Task> leaderTasks) {
        this.leaderTasks = leaderTasks;
    }

    public void addLeaderTask(Task task) {
        leaderTasks.add(task);
        task.setLeader(this);
    }

    public void removeLeaderTask(Task task) {
        leaderTasks.remove(task);
        task.setLeader(null);
    }
}

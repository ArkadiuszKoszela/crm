package pl.lanshela.crm.model;


import javax.persistence.*;
import java.util.List;

@Entity(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @Column(name = "user_data_id")
    private UserData userData;
    @OneToOne
    @Column(name = "personal_data_id")
    private PersonalData personalData;
    @ManyToOne
    @JoinColumn(name = "consultant_id")
    private List<Employee> consultants;

    public Client() {
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

    public List<Employee> getConsultants() {
        return consultants;
    }

    public void setConsultants(List<Employee> consultants) {
        this.consultants = consultants;
    }
}

package pl.lanshela.crm.model;


import pl.lanshela.crm.model.dto.ClientDto;

import javax.persistence.*;

@Entity(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "personal_data_id")
    private PersonalData personalData;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee consultant;

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public Employee getConsultant() {
        return consultant;
    }

    public void setConsultant(Employee consultant) {
        this.consultant = consultant;
    }
}

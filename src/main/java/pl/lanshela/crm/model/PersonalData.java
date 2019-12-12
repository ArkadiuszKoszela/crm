package pl.lanshela.crm.model;

import org.springframework.format.annotation.DateTimeFormat;
import pl.lanshela.crm.model.dto.ClientDto;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "personal_data")
public class PersonalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personal_data_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthDate;

    public PersonalData() {
    }

    public PersonalData(ClientDto clientDto) {
        firstName = clientDto.getFirstName();
        lastName = clientDto.getLastName();
        birthDate = clientDto.getBirthDate();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}

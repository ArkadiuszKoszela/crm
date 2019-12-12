package pl.lanshela.crm.model.dto;

import org.springframework.format.annotation.DateTimeFormat;
import pl.lanshela.crm.model.Client;
import pl.lanshela.crm.model.Employee;

import java.util.Date;
import java.util.List;

public class ClientDto {
    private Long id;
    private String firstName;
    private String lastName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthDate;
    private Long consultantId;
    private List<Employee> employees;

    public ClientDto() {
    }

    public ClientDto(List<Employee> employees) {
        this.employees = employees;
    }

    public ClientDto(Client client, List<Employee> employees) {
        id = client.getId();
        firstName = client.getPersonalData().getFirstName();
        lastName = client.getPersonalData().getLastName();
        birthDate = client.getPersonalData().getBirthDate();
        consultantId = client.getConsultant().getId();
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(Long consultantId) {
        this.consultantId = consultantId;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

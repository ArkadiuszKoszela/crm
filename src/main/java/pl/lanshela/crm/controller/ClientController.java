package pl.lanshela.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pl.lanshela.crm.model.Client;
import pl.lanshela.crm.model.Employee;
import pl.lanshela.crm.model.PersonalData;
import pl.lanshela.crm.model.dto.ClientDto;
import pl.lanshela.crm.service.ClientService;
import pl.lanshela.crm.service.EmployeeService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;
    private EmployeeService employeeService;

    @Autowired
    public ClientController(ClientService clientService, EmployeeService employeeService) {
        this.clientService = Objects.requireNonNull(clientService, "Client Service not found. It must be included.");
        this.employeeService = Objects.requireNonNull(employeeService, "Employee Service not found. It must be included.");
    }

    @GetMapping("/add")
    public ModelAndView addClientPage() {
        List<Employee> employees = employeeService.findAll();
        return new ModelAndView("/clients/addForm")
                .addObject("client", new ClientDto(employees));
    }

    @PostMapping("/add")
    public RedirectView saveClient(@ModelAttribute ClientDto clientDto) {
        PersonalData personalData = new PersonalData(clientDto);
        Employee consultant = employeeService.findById(clientDto.getConsultantId());
        Client client = new Client();
        client.setPersonalData(personalData);
        client.setConsultant(consultant);
        clientService.save(client);
        return new RedirectView("/clients/list");
    }

    @GetMapping("/list")
    public ModelAndView clientListPage() {
        List<Client> clients = clientService.findAll();
        return new ModelAndView("/clients/list").addObject("clients", clients);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView clientEditPage(@PathVariable Long id) {
        List<Employee> employees = employeeService.findAll();
        ClientDto clientDto = new ClientDto(clientService.findById(id), employees);
        return new ModelAndView("/clients/editForm").addObject("client", clientDto);
    }

    @PostMapping("/edit")
    public RedirectView clientEdit(@ModelAttribute ClientDto clientDto) {
        Client client = clientService.findById(clientDto.getId());
        PersonalData personalData = new PersonalData(clientDto);
        Employee employee = employeeService.findById(clientDto.getConsultantId());

        client.setPersonalData(personalData);
        client.setConsultant(employee);

        clientService.save(client);
        return new RedirectView("/clients/list");
    }

}

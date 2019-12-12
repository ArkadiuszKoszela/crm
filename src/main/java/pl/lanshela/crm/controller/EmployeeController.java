package pl.lanshela.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pl.lanshela.crm.model.Employee;
import pl.lanshela.crm.service.ClientService;
import pl.lanshela.crm.service.EmployeeService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    private ClientService clientService;


    @Autowired
    public EmployeeController(EmployeeService employeeService, ClientService clientService) {
        this.employeeService = Objects.requireNonNull(employeeService, "Employee service not found. It must be included");
        this.clientService = Objects.requireNonNull(clientService, "Client service not found. It must be included");
    }

    @GetMapping("/register")
    public ModelAndView employeeFormPage() {
        return new ModelAndView("employees/registerForm").addObject("employee", new Employee());
    }

    @PostMapping("/register")
    public RedirectView employeeRegister(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return new RedirectView("/employees/list");
    }

    @GetMapping("/list")
    public ModelAndView employeeListPage() {
        List<Employee> employees = employeeService.findAll();
        return new ModelAndView("employees/list").addObject("employees", employees);
    }

}

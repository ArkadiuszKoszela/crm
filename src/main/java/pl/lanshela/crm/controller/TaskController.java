package pl.lanshela.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pl.lanshela.crm.model.Employee;
import pl.lanshela.crm.model.Task;
import pl.lanshela.crm.model.TaskStatus;
import pl.lanshela.crm.model.dto.TaskDto;
import pl.lanshela.crm.service.EmployeeService;
import pl.lanshela.crm.service.TaskService;
import pl.lanshela.crm.service.UtilitiesService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private EmployeeService employeeService;
    private TaskService taskService;
    private UtilitiesService utilitiesService;

    @Autowired
    public TaskController(EmployeeService employeeService, TaskService taskService, UtilitiesService utilitiesService) {
        this.employeeService = Objects.requireNonNull(employeeService, "Employee service not found. It must be included.");
        this.taskService = Objects.requireNonNull(taskService, "Task service not found. It must be included.");
        this.utilitiesService = Objects.requireNonNull(utilitiesService, "Utilities service not found. It must be included.");
    }

    @GetMapping("/create")
    public ModelAndView taskFormPage() {
        List<Employee> availableEmployees = employeeService.findAll();
        List<TaskStatus> availableTaskStatuses = utilitiesService.findAllTaskStatuses();
        return new ModelAndView("tasks/createForm")
                .addObject("task", new TaskDto(availableEmployees,availableTaskStatuses));
    }

    @PostMapping("/create")
    public RedirectView taskCreation(@ModelAttribute TaskDto taskDto) {
        Task task = new Task(taskDto);
        Employee leader = employeeService.findById(taskDto.getLeaderId());
        TaskStatus taskStatus = utilitiesService.findTaskStatusById(taskDto.getTaskStatusId());
        task.setLeader(leader);
        task.setTaskStatus(taskStatus);
        taskService.save(task);
        return new RedirectView("/tasks/list");
    }

    @GetMapping("/list")
    public ModelAndView tasksListPage() {
        List<Task> tasks = taskService.findAll();
        return new ModelAndView("tasks/list").addObject("tasks", tasks);
    }

}

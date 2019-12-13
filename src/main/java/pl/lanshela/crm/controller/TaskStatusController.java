package pl.lanshela.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pl.lanshela.crm.model.TaskStatus;
import pl.lanshela.crm.service.UtilitiesService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/statuses")
public class TaskStatusController {

    private UtilitiesService utilitiesService;

    @Autowired
    public TaskStatusController(UtilitiesService utilitiesService) {
        this.utilitiesService = Objects.requireNonNull(utilitiesService,"Utilities service not found. It must be included.");
    }

    @GetMapping("/create")
    public ModelAndView createTaskStatusPage(){
        return new ModelAndView("/utilities/createStatusForm").addObject("taskStatus", new TaskStatus());
    }

    @PostMapping("/create")
    public RedirectView taskStatusCreation(@ModelAttribute TaskStatus taskStatus){
        utilitiesService.saveTaskStatus(taskStatus);
        return new RedirectView("/statuses/list");
    }

    @GetMapping("/list")
    public ModelAndView taskStatusesListPage(){
        List<TaskStatus> taskStatuses = utilitiesService.findAllTaskStatuses();
        return new ModelAndView("/utilities/statusesList").addObject("taskStatuses", taskStatuses);
    }
}

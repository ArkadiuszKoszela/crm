package pl.lanshela.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lanshela.crm.model.TaskStatus;
import pl.lanshela.crm.repository.TaskStatusRepository;

import java.util.Objects;

@Service
public class UtilitiesService {

    private TaskStatusRepository taskStatusRepository;

    @Autowired
    public UtilitiesService(TaskStatusRepository taskStatusRepository) {
        this.taskStatusRepository = Objects.requireNonNull(taskStatusRepository,"Task status repository not found. It must be included");
    }

    public void saveTaskStatus(TaskStatus taskStatus){
        taskStatusRepository.save(taskStatus);
    }
}

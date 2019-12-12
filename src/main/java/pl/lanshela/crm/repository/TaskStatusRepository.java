package pl.lanshela.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lanshela.crm.model.TaskStatus;

@Repository(value = "task_status_repository")
public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {
}

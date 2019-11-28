package pl.lanshela.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lanshela.crm.model.Task;

@Repository(value = "task_repository")
public interface TaskRepository extends JpaRepository<Task, Long> {
}

package pl.lanshela.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lanshela.crm.model.UserData;

@Repository(value = "user_data_repository")
public interface UserDataRepository extends JpaRepository<UserData, Long> {
}

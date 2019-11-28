package pl.lanshela.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lanshela.crm.model.PersonalData;

@Repository(value = "personal_data_repository")
public interface PersonalDataRepository extends JpaRepository<PersonalData, Long> {
}

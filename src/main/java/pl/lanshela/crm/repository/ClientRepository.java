package pl.lanshela.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lanshela.crm.model.Client;

@Repository(value = "client_repository")
public interface ClientRepository extends JpaRepository<Client, Long> {
}

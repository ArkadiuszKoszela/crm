package pl.lanshela.crm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lanshela.crm.model.Client;
import pl.lanshela.crm.model.dto.ClientDto;
import pl.lanshela.crm.repository.ClientRepository;
import pl.lanshela.crm.repository.PersonalDataRepository;
import pl.lanshela.crm.repository.UserDataRepository;

import java.util.List;
import java.util.Objects;

@Service
public class ClientService {

    private ClientRepository clientRepository;
    private UserDataRepository userDataRepository;
    private PersonalDataRepository personalDataRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, UserDataRepository userDataRepository, PersonalDataRepository personalDataRepository) {
        this.clientRepository = Objects.requireNonNull(clientRepository, "Client repository not found. It must be included.");
        this.userDataRepository = Objects.requireNonNull(userDataRepository, "User Data repository not found. It must be included.");
        this.personalDataRepository = Objects.requireNonNull(personalDataRepository, "Personal Data repository not found. It must be included.");
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public void save(Client client) {
        personalDataRepository.save(client.getPersonalData());
        clientRepository.save(client);
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).get();
    }
}

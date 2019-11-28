package pl.lanshela.crm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lanshela.crm.repository.ClientRepository;
import pl.lanshela.crm.repository.PersonalDataRepository;
import pl.lanshela.crm.repository.UserDataRepository;

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
}

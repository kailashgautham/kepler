package com.kailashgautham.kepler.Client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/clients")
    public Iterable<Client> getAllClients() {
        return this.clientRepository.findAll();
    }

    @PostMapping("/clients")
    public Client addNewClient(@RequestBody Client client) {
        return this.clientRepository.save(client);
    }

}
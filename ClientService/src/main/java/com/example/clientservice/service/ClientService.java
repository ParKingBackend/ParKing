package com.example.clientservice.service;

import com.example.clientservice.model.Client;
import com.example.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class ClientService {
    private static final Logger log = LoggerFactory.getLogger(ClientService.class);



    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void registerClient(String username, String password, String email) {
        // Hash the password using BCrypt
        String hashedPassword = passwordEncoder.encode(password);

        // Create a new Client object and set the hashed password
        Client client = new Client();
        client.setUsername(username);
        client.setPassword(hashedPassword);
        client.setEmail(email);

        // Save the client in the database
        clientRepository.save(client);
    }
    public Client findByUsername(String username) {
        return clientRepository.findByUsername(username);
    }

    public Client findById(Long clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }

    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }

    public boolean clientExists(Long clientId) {
        return clientRepository.existsById(clientId);
    }

    public boolean deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true; // Deletion was successful
        } else {
            return false; // Client with the specified ID not found
        }
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public void addBankAccount(Long clientId, String bankAccount) {
        clientRepository.addBankAccount(clientId, bankAccount);
    }

    public void addImage(Long clientId, String image) {
        clientRepository.addImage(clientId, image);
    }
}

package com.example.clientservice.service;

import com.example.clientservice.model.Client;
import com.example.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class ClientService {
    private static final Logger log = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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

}

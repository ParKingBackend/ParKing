package com.example.clientservice.web.controller;

import com.example.clientservice.model.Client;
import com.example.clientservice.service.ClientService;
import com.example.clientservice.service.request.ClientLoginRequest;
import com.example.clientservice.service.request.ClientRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerClient(@RequestBody ClientRegistrationRequest registrationRequest) {
        try {
            String username = registrationRequest.getUsername();
            String password = registrationRequest.getPassword();
            String email = registrationRequest.getEmail();

            // Check if the username is already taken
            if (clientService.findByUsername(username) != null) {
                return ResponseEntity.badRequest().body("Username is already taken");
            }

            clientService.registerClient(username, password, email);

            return ResponseEntity.ok("Client registration successful");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Client registration failed");
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        try {
            Client client = clientService.findByUsername(username);

            if (client == null) {
                return ResponseEntity.badRequest().body("Client not found");
            }

            String hashedPasswordFromDatabase = client.getPassword();

            if (passwordEncoder.matches(password, hashedPasswordFromDatabase)) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.badRequest().body("Login failed: Incorrect password");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Login failed");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        try {
            Client client = clientService.findById(id);

            if (client == null) {
                return ResponseEntity.badRequest().body(null);
            }

            return ResponseEntity.ok(client);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
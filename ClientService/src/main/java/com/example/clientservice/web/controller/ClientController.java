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
    public ResponseEntity<String> registerClient(@RequestBody Client client) {
        try {
            String username = client.getUsername();
            String password = client.getPassword();
            String email = client.getEmail();

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
            String hashedPasswordAttempt = passwordEncoder.encode(password);

            /* System.out.println("Hashed Password from Database: " + hashedPasswordFromDatabase);
             System.out.println("Hashed Password from Login Attempt: " + hashedPasswordAttempt);*/

            if (passwordEncoder.matches(password, hashedPasswordFromDatabase)) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.badRequest().body("Login failed: Incorrect password");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Login failed");
        }
    }
}
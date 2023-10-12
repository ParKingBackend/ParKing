package com.example.clientservice.web.controller;

import com.example.clientservice.model.Client;
import com.example.clientservice.model.PremiumSubscription;
import com.example.clientservice.service.ClientService;
import com.example.clientservice.service.PremiumSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscription")
public class PremiumSubscriptionController {

    @Autowired
    private PremiumSubscriptionService premiumSubscriptionService;

    @Autowired
    private ClientService clientService;

    @PostMapping("/create/{clientId}")
    public ResponseEntity<String> createSubscription(@PathVariable Long clientId, @RequestBody PremiumSubscription subscription) {
        try {
            // Fetch the client from the database based on the clientId
            Client client = clientService.findById(clientId);

            if (client == null) {
                return ResponseEntity.badRequest().body("Client not found");
            }

            // Set the client for the subscription
            subscription.setClient(client);

            // Save the premium subscription to the database
            premiumSubscriptionService.saveSubscription(subscription);

            return ResponseEntity.ok("Premium subscription created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to create premium subscription");
        }
    }
}

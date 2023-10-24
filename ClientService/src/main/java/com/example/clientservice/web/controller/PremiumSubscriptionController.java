package com.example.clientservice.web.controller;

import com.example.clientservice.model.Client;
import com.example.clientservice.model.PremiumSubscription;
import com.example.clientservice.service.ClientService;
import com.example.clientservice.service.PremiumSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscription")
public class PremiumSubscriptionController {

    @Autowired
    private PremiumSubscriptionService premiumSubscriptionService;

    @Autowired
    private ClientService clientService;

    @PostMapping("/create/{clientId}")
    public ResponseEntity<String> createPremiumSubscription(@PathVariable Long clientId, @RequestBody PremiumSubscription subscription) {
        Client client = clientService.findById(clientId);

        if (client == null) {
            return ResponseEntity.badRequest().body("Client not found");
        }

        subscription.setClient(client);

        premiumSubscriptionService.saveSubscription(subscription);

        return ResponseEntity.ok("Premium subscription created successfully");
    }

    @GetMapping("/get/all")
    public List<PremiumSubscription> getAllPremiumSubscriptions() {
        return premiumSubscriptionService.getAllSubscriptions();
    }



}

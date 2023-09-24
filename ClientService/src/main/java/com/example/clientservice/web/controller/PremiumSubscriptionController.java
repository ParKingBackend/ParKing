package com.example.clientservice.web.controller;

import com.example.clientservice.model.Client;
import com.example.clientservice.model.PremiumSubscription;
import com.example.clientservice.service.PremiumSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/premium-subscriptions")
public class PremiumSubscriptionController {

    private final PremiumSubscriptionService premiumSubscriptionService;

    @Autowired
    public PremiumSubscriptionController(PremiumSubscriptionService premiumSubscriptionService) {
        this.premiumSubscriptionService = premiumSubscriptionService;
    }

}

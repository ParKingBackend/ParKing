package com.example.clientservice.service;

import com.example.clientservice.model.Client;
import com.example.clientservice.model.PremiumSubscription;
import com.example.clientservice.repository.PremiumSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremiumSubscriptionService {

    private final PremiumSubscriptionRepository premiumSubscriptionRepository;

    @Autowired
    public PremiumSubscriptionService(PremiumSubscriptionRepository premiumSubscriptionRepository) {
        this.premiumSubscriptionRepository = premiumSubscriptionRepository;
    }

}

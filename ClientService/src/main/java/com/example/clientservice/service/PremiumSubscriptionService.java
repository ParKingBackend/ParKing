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

    public List<PremiumSubscription> getAllSubscriptions() {
        return premiumSubscriptionRepository.findAll();
    }


    public PremiumSubscription createPremiumSubscription(PremiumSubscription premiumSubscription) {
        return premiumSubscriptionRepository.save(premiumSubscription);
    }

    public PremiumSubscription updatePremiumSubscription(Long id, PremiumSubscription updatedPremiumSubscription) {
        // Find the existing person by ID
        PremiumSubscription existingPremiumSubscription = premiumSubscriptionRepository.findById(id).orElse(null);

        if (existingPremiumSubscription != null) {
            // Update the fields of the existing person with the values from the updatedPerson
            existingPremiumSubscription.setEndDate(updatedPremiumSubscription.getEndDate());
            existingPremiumSubscription.setDiscountAmount(updatedPremiumSubscription.getDiscountAmount());

            // Save the updated person
            return premiumSubscriptionRepository.save(existingPremiumSubscription);
        } else {
            // Person with the specified ID not found, return null or throw an exception
            return null; // You can also throw an exception if you prefer
        }
    }
}

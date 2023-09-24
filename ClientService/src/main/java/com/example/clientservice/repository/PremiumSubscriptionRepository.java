package com.example.clientservice.repository;

import com.example.clientservice.model.PremiumSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PremiumSubscriptionRepository extends JpaRepository<PremiumSubscription, Long> {

}

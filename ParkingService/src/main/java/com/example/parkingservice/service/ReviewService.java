package com.example.parkingservice.service;

import com.example.parkingservice.model.Review;
import com.example.parkingservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }
    public Review findById(Long clientId) {
        return reviewRepository.findById(clientId).orElse(null);
    }

}

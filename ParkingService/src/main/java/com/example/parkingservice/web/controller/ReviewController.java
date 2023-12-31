package com.example.parkingservice.web.controller;


import com.example.parkingservice.model.Review;
import com.example.parkingservice.model.Parking;
import com.example.parkingservice.service.ParkingService;
import com.example.parkingservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    private final ReviewService reviewService;
    private final ParkingService parkingService;
    @Autowired
    public ReviewController(ReviewService reviewService, ParkingService parkingService) {
        this.reviewService = reviewService;
        this.parkingService = parkingService;
    }
    @PostMapping("/add/{parkingId}")
    public ResponseEntity<Object> createReview(@PathVariable Long parkingId, @RequestBody Review review) {
        Optional<Parking> optionalParking = Optional.ofNullable(parkingService.findById(parkingId));
        if (optionalParking.isPresent()) {
            Parking parking = optionalParking.get();
            review.setParking(parking);
            review.setPostedTime(LocalDateTime.now());
            Review createdReview = reviewService.createReview(review);
            return ResponseEntity.ok(createdReview);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Parking with id " + parkingId + " not found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        try {
            Review Review = reviewService.findById(id);

            if (Review == null) {
                return ResponseEntity.badRequest().body(null);
            }

            return ResponseEntity.ok(Review);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}

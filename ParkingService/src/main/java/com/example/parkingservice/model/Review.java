package com.example.parkingservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private double rating;

    @Column(name = "posted_time")
    private LocalDateTime postedTime;

    private Long clientId;

    @ManyToOne
    @JoinColumn(name = "parking_id")
    private Parking parking;

    // Constructors, getters, and setters

    public Review() {
        // Default constructor
    }

    public Review(String title, String description, double rating, Long clientId, Parking parking) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.clientId = clientId;
        this.parking = parking;
        this.postedTime = LocalDateTime.now(); // Set the posted time to the current local time
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDateTime getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(LocalDateTime postedTime) {
        this.postedTime = postedTime;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClient(Long clientId) {
        this.clientId = clientId;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", postedTime=" + postedTime +
                '}';
    }
}

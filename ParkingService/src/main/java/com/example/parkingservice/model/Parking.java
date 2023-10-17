package com.example.parkingservice.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "parking")
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private BigDecimal price;
    private boolean isPremium;

    @Column(name = "partner_id")
    private Long partnerId;

    @Column(name = "max_spots_count")
    private int maxSpotsCount;

    @Column(name = "spots_taken")
    private int spotsTaken;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "is_Disabled")
    private boolean isDisabled;

    // Constructors

    public Parking() {
        // Default constructor
    }

    public Parking(String address, BigDecimal price, boolean isPremium, Long partnerId, int maxSpotsCount, int spotsTaken, LocalDateTime startTime, LocalDateTime endTime, boolean isDisabled) {
        this.address = address;
        this.price = price;
        this.isPremium = isPremium;
        this.partnerId = partnerId;
        this.maxSpotsCount = maxSpotsCount;
        this.spotsTaken = spotsTaken;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isDisabled = isDisabled;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public int getMaxSpotsCount() {
        return maxSpotsCount;
    }

    public void setMaxSpotsCount(int maxSpotsCount) {
        this.maxSpotsCount = maxSpotsCount;
    }

    public int getSpotsTaken() {
        return spotsTaken;
    }

    public void setSpotsTaken(int spotsTaken) {
        this.spotsTaken = spotsTaken;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Parking{" + "id=" + id + ", address='" + address + '\'' + ", price=" + price + ", isPremium=" + isPremium + ", partnerId=" + partnerId + ", maxSpotsCount=" + maxSpotsCount + ", spotsTaken=" + spotsTaken + ", startTime=" + startTime + ", endTime=" + endTime + '}';
    }
}

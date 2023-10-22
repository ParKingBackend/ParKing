package com.example.parkingservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "parking")
@Getter
@Setter
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String address;
    @Getter
    @Setter
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



    public boolean isPremium() {
        return isPremium;
    }
    public void setDisabled(boolean isDisabled){this.isDisabled = isDisabled;}
    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    @Override
    public String toString() {
        return "Parking{" + "id=" + id + ", address='" + address + '\'' + ", price=" + price + ", isPremium=" + isPremium + ", partnerId=" + partnerId + ", maxSpotsCount=" + maxSpotsCount + ", spotsTaken=" + spotsTaken + ", startTime=" + startTime + ", endTime=" + endTime + '}';
    }
}

package com.example.parkingservice.service.request;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class AddParkingRequest {
    private String address;
    private LocalDateTime endTime;
    private boolean isDisabled;
    private boolean isPremium;
    private int maxSpotsCount;
    private Long partnerId;
    private BigDecimal price;
    private int spotsTaken;
    private LocalDateTime startTime;

    public AddParkingRequest(){

    }
    public AddParkingRequest(String address, LocalDateTime endTime, boolean isDisabled, boolean isPremium, int maxSpotsCount, Long partnerId, BigDecimal price, int spotsTaken, LocalDateTime startTime ){

        this.address = address;
        this.endTime = endTime;
        this.isDisabled = isDisabled;
        this.isPremium = isPremium;
        this.maxSpotsCount = maxSpotsCount;
        this.partnerId = partnerId;
        this.price = price;
        this.spotsTaken = spotsTaken;
        this.startTime = startTime;

    }
    public boolean getDisabled() {return this.isDisabled;}
    public boolean getPremium() {return this.isPremium;}


}

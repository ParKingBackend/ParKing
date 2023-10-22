package com.example.parkingservice.web.controller;

import com.example.parkingservice.service.ParkingService;
import com.example.parkingservice.service.request.AddParkingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;
    private static final Logger logger = LoggerFactory.getLogger(ParkingController.class);
    @PostMapping("/add")
    public ResponseEntity<String> addParking(@RequestBody AddParkingRequest parkingRequest){

        try{
            String address = parkingRequest.getAddress();
            LocalDateTime endTime = parkingRequest.getEndTime();
            boolean isDisabled = parkingRequest.getDisabled();
            boolean isPremium = parkingRequest.getPremium();
            int maxSpotsCount = parkingRequest.getMaxSpotsCount();
            Long partnerId = parkingRequest.getPartnerId();
            BigDecimal price = parkingRequest.getPrice();
            int spotsTaken = parkingRequest.getSpotsTaken();
            LocalDateTime startTime = parkingRequest.getStartTime();
            logger.info("ParkingController isPremium: {}, isDisabled: {}", isPremium, isDisabled);



            parkingService.addParking(address, endTime, isDisabled, isPremium, maxSpotsCount, partnerId, price, spotsTaken, startTime);
            return ResponseEntity.ok("Parking spot added!");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Didn't suceed to add the parking spot!");
        }
    }

}

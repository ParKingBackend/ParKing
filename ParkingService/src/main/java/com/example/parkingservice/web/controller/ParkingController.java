package com.example.parkingservice.web.controller;

import com.example.parkingservice.model.Parking;
import com.example.parkingservice.service.ParkingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/parking")
public class ParkingController {


    private final ParkingService parkingService;
    @Autowired
    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }
    @PostMapping("/add")
    public Parking createParking(@RequestBody Parking parking) {
        return parkingService.createParking(parking);
    }


}

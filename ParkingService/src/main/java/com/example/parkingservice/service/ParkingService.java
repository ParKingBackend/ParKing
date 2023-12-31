package com.example.parkingservice.service;

import com.example.parkingservice.model.Parking;
import com.example.parkingservice.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    @Autowired
    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }
    private static final Logger LOGGER = Logger.getLogger(ParkingService.class.getName());
    public Parking createParking(Parking parking) {
        if (parking.getStartTime() == null) {
            parking.setStartTime(LocalDateTime.now());
        }
        return parkingRepository.save(parking);
    }
    public Parking findById(Long parkingId) {
        return parkingRepository.findById(parkingId).orElse(null);
    }
}

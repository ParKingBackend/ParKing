package com.example.parkingservice.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import com.example.parkingservice.model.Parking;
import com.example.parkingservice.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ParkingService {
    private static final Logger logger = LoggerFactory.getLogger(ParkingService.class);
    @Autowired
    private ParkingRepository parkingRepository;

    public void addParking(String address, LocalDateTime endTime, boolean isDisabled, boolean isPremium, int maxSpotsCount, Long partnerId, BigDecimal price, int spotsTaken, LocalDateTime startTime ) {
        logger.info("ParkingService isPremium: {}, isDisabled: {}", isPremium, isDisabled);
        Parking parking = new Parking();
        parking.setAddress(address);
        parking.setEndTime(endTime);
        parking.setDisabled(isDisabled);
        parking.setPremium(isPremium);
        parking.setMaxSpotsCount(maxSpotsCount);
        parking.setPartnerId(partnerId);
        parking.setPrice(price);
        parking.setSpotsTaken(spotsTaken);
        parking.setStartTime(startTime);

        parkingRepository.save(parking);
    }


    public Parking findByAddress(String address) { return parkingRepository.findByAddress(address); }
    public Parking findById(Long parkingId) {return parkingRepository.findById(parkingId).orElse(null);}
}

package com.example.parkingservice.service;

import com.example.parkingservice.model.Parking;
import com.example.parkingservice.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    @Autowired
    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public Parking createParking(Parking parking) {
        return parkingRepository.save(parking);
    }

}

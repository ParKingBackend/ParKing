package com.example.parkingservice.service;

import com.example.parkingservice.model.Reservations;
import com.example.parkingservice.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class ReservationsService {

    private final ReservationsRepository reservationsRepository;

    @Autowired
    public ReservationsService(ReservationsRepository reservationsRepository) {
        this.reservationsRepository = reservationsRepository;
    }

    public Reservations createReservations(Reservations reservations) {

        return reservationsRepository.save(reservations);
    }
    public Reservations findById(Long clientId) {
        return reservationsRepository.findById(clientId).orElse(null);
    }
}

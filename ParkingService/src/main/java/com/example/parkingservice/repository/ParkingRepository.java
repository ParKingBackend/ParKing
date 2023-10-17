package com.example.parkingservice.repository;

import com.example.parkingservice.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long>{

}

package com.springboot.parkeasy.service;

import com.springboot.parkeasy.model.Parking;
import com.springboot.parkeasy.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    public List<Parking> getAllParkings() {
        return parkingRepository.findAll();
    }

    public Parking getParkingById(Long id) {
        return parkingRepository.findById(id).orElse(null);
    }

    public void addParking(Parking parking) {
        parkingRepository.save(parking);
    }
}

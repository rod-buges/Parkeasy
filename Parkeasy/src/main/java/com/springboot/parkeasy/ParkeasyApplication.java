package com.springboot.parkeasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.parkeasy.model.Parking;
import com.springboot.parkeasy.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ParkeasyApplication implements CommandLineRunner {

    @Autowired
    private ParkingRepository parkingRepository;

    public static void main(String[] args) {
        SpringApplication.run(ParkeasyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Adicionar via inha de comando estacionamentos ao banco de dados

    }
}

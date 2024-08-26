package com.springboot.parkeasy.controller;

import com.springboot.parkeasy.model.Parking;
import com.springboot.parkeasy.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    private ParkingRepository parkingRepository;

    @GetMapping
    public String listAllParkings(Model model) {
        List<Parking> parkings = parkingRepository.findAll();
        model.addAttribute("parkings", parkings);
        return "parkingList";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("parking", new Parking());
        return "createParking";
    }

    @PostMapping
    public String createParking(@ModelAttribute Parking parking) {
        parkingRepository.save(parking);
        return "redirect:/parking";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Parking parking = parkingRepository.findById(id).orElse(null);
        if (parking != null) {
            model.addAttribute("parking", parking);
            return "editParking";
        } else {
            return "redirect:/parking";
        }
    }

    @PostMapping("/update/{id}")
    public String updateParking(@PathVariable("id") Long id, @ModelAttribute Parking updatedParking) {
        Parking parking = parkingRepository.findById(id).orElse(null);
        if (parking != null) {
            parking.setName(updatedParking.getName());
            parking.setAddress(updatedParking.getAddress());
            parking.setPrice1(updatedParking.getPrice1());
            parking.setPrice2(updatedParking.getPrice2());
            parking.setPrice3(updatedParking.getPrice3());
            parking.setSpaces(updatedParking.getSpaces());
            parking.setLatitude(updatedParking.getLatitude());
            parking.setLongitude(updatedParking.getLongitude());
            parkingRepository.save(parking);
        }
        return "redirect:/parking";
    }

    @GetMapping("/delete/{id}")
    public String deleteParking(@PathVariable("id") Long id) {
        parkingRepository.deleteById(id);
        return "redirect:/parking";
    }

    // Nova rota para obter todos os estacionamentos em JSON
    @GetMapping("/api/parkings")
    @ResponseBody
    public List<Parking> getAllParkings() {
        return parkingRepository.findAll();
    }

    @GetMapping("/api/parking/{id}")
    @ResponseBody
    public ResponseEntity<Parking> getParkingDetails(@PathVariable("id") Long id) {
        Parking parking = parkingRepository.findById(id).orElse(null);
        if (parking != null) {
            return ResponseEntity.ok(parking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

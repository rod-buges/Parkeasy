package com.springboot.parkeasy.controller;

import com.springboot.parkeasy.model.Parking;
import com.springboot.parkeasy.model.Reservation;
import com.springboot.parkeasy.repository.ParkingRepository;
import com.springboot.parkeasy.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/home")
    public String home(Model model) {
        // Busca todos os estacionamentos do banco de dados
        List<Parking> parkings = parkingRepository.findAll();
        // Adiciona a lista de estacionamentos ao modelo para ser usada na página
        model.addAttribute("parkings", parkings);
        return "home"; // Retorna a página home.html
    }

    @GetMapping("/parkingDetails/{id}")
    public String parkingDetails(@PathVariable Long id, Model model) {
        Parking parking = parkingRepository.findById(id).orElse(null);
        model.addAttribute("parking", parking);
        return "parkingDetails";
    }

    // Novo endpoint para obter estacionamentos em JSON
    @GetMapping("/api/parkings")
    @ResponseBody
    public List<Parking> getAllParkings() {
        return parkingRepository.findAll();
    }

    @GetMapping("/api/parkings/{id}")
    @ResponseBody
    public ResponseEntity<Parking> getParkingById(@PathVariable Long id) {
        Optional<Parking> parking = parkingRepository.findById(id);
        if (parking.isPresent()) {
            return ResponseEntity.ok(parking.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoints para gerenciamento de reservas

    @GetMapping("/reservations")
    public String reservationsPage(Model model) {
        List<Reservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations", reservations);
        return "reservations"; // Retorna a página reservations.html
    }

    @GetMapping("/reservation/{id}")
    public String reservationDetails(@PathVariable Long id, Model model) {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        if (reservation.isPresent()) {
            model.addAttribute("reservation", reservation.get());
            return "reservationDetails"; // Retorna a página reservationDetails.html
        } else {
            return "redirect:/reservations"; // Redireciona se a reserva não for encontrada
        }
    }

    @GetMapping("/reservation/new")
    public String newReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("parkings", parkingRepository.findAll());
        // Supondo que você está obtendo os preços dos estacionamentos selecionados
        List<String> availablePrices = List.of("30MIN", "1H", "2H"); // Exemplo de preços, ajuste conforme necessário
        model.addAttribute("availablePrices", availablePrices);
        return "reservationForm";
    }

    @PostMapping("/reservation")
    public String createReservation(@ModelAttribute Reservation reservation) {
        reservationService.saveReservation(reservation);
        return "redirect:/reservations"; // Redireciona para a lista de reservas após a criação
    }

    @GetMapping("/reservation/edit/{id}")
    public String editReservationForm(@PathVariable Long id, Model model) {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        if (reservation.isPresent()) {
            model.addAttribute("reservation", reservation.get());
            model.addAttribute("parkings", parkingRepository.findAll());
            // Supondo que você está obtendo os preços dos estacionamentos selecionados
            List<String> availablePrices = List.of("30MIN", "1H", "2H"); // Exemplo de preços, ajuste conforme necessário
            model.addAttribute("availablePrices", availablePrices);
            return "reservationForm";
        } else {
            return "redirect:/reservations";
        }
    }

    @PostMapping("/reservation/update/{id}")
    public String updateReservation(@PathVariable Long id, @ModelAttribute Reservation reservation) {
        reservation.setId(id);
        reservationService.updateReservation(id, reservation);
        return "redirect:/reservations"; // Redireciona para a lista de reservas após a atualização
    }

    @PostMapping("/reservation/delete/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return "redirect:/reservations"; // Redireciona para a lista de reservas após a exclusão
    }
}

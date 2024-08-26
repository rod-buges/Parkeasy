package com.springboot.parkeasy.service;

import com.springboot.parkeasy.model.Reservation;
import com.springboot.parkeasy.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    // Criar uma nova reserva
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Encontrar todas as reservas
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Encontrar uma reserva por ID
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    // Atualizar uma reserva
    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        if (reservationRepository.existsById(id)) {
            reservationDetails.setId(id);
            return reservationRepository.save(reservationDetails);
        } else {
            // Lançar uma exceção ou retornar um valor padrão, se a reserva não for encontrada
            return null;
        }
    }

    // Excluir uma reserva por ID
    public void deleteReservation(Long id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
        } else {
            // Lançar uma exceção ou retornar um valor padrão, se a reserva não for encontrada
        }
    }
}


package com.springboot.parkeasy.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String vehicleModel;

    @Column(nullable = false)
    private String vehicleColor;

    @Column(nullable = false, unique = true)
    private String vehiclePlate;

    @Column(nullable = false)
    private String paymentMethod; // PIX, Dinheiro, etc.

    @Column(nullable = false)
    private String price;

    @ManyToOne
    @JoinColumn(name = "parking_id", nullable = false)
    private Parking parking;

    public Reservation(String vehicleModel, String vehicleColor, String vehiclePlate,
                       String paymentMethod, String price,
                       Parking parking) {
        this.vehicleModel = vehicleModel;
        this.vehicleColor = vehicleColor;
        this.vehiclePlate = vehiclePlate;
        this.paymentMethod = paymentMethod;
        this.price = price;
        this.parking = parking;
    }
}

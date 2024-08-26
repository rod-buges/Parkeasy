package com.springboot.parkeasy.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Entity
@Table (name = "parking")
@Getter
@Setter
@NoArgsConstructor
public class Parking{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String address;
    @Column(nullable = false)
    private String price1;
    @Column(nullable = false)
    private String price2;
    @Column(nullable = false)
    private String price3;
    @Column(nullable = false)
    private int spaces;
    @Column(nullable = false)
    private double latitude;
    @Column(nullable = false)
    private double longitude;

    public Parking(String name, String address, String price1, String price2, String price3, int spaces, double latitude, double longitude) {
        this.name = name;
        this.address = address;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
        this.spaces = spaces;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

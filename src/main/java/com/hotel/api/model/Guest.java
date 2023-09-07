package com.hotel.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String password;

    @OneToMany(mappedBy = "guest",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();
}

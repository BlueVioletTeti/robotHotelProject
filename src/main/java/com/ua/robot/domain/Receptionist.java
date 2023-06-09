package com.ua.robot.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table (name = "admins")
public class Receptionist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private int phoneNumber;

    @OneToMany(mappedBy = "receptionist")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "receptionist")
    private List<Room> rooms;

    @OneToMany(mappedBy = "receptionist")
    private List<Guest> guests;


}

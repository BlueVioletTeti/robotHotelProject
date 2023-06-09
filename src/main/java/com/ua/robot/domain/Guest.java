package com.ua.robot.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table (name = "guests")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String guestName;
    @Column
    private String guestSurname;
    @Column
    private int passportId;
    @Column
    private int phoneNumber;
    @Column
    private String address;

    @ManyToMany
    @JoinColumn(name = "reservation_id")
    private List<Reservation> reservations;
    @ManyToOne
    @JoinColumn(name = "receptionist_id")
    private Receptionist receptionist;
}

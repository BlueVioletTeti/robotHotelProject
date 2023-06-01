package com.ua.robot.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String type;
    @Column
    private int capacity;
    @Column
    private Long roomPrice;
    @Column
    private String description;

    @ManyToMany
    @JoinColumn(name = "reservation_id")
    private List<Reservation> reservations;
    @ManyToOne
    @JoinColumn(name = "receptionist_id")
    private Receptionist receptionist;

}

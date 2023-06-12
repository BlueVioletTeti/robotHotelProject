package com.ua.robot.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table (name = "reservations")
@EnableScheduling
@EnableTransactionManagement

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "arrival_date")
    @Temporal(TemporalType.DATE)
    private LocalDate arrivalDate;
    @Column(name = "departure_date")
    @Temporal(TemporalType.DATE)
    private LocalDate departureDate;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

}
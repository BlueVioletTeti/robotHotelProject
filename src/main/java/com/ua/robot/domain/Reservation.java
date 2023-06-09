package com.ua.robot.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

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
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate arrivalDate;
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate departureDate;

//    @Column
//    private int calculateLengthOfStay(LocalDate arrivalDate, LocalDate departureDate) {
//        Period period = Period.between(arrivalDate, departureDate);
//        return Math.abs(period.getDays());
//    }

    @ManyToMany
    @JoinColumn(name = "guest_id")
    private List<Guest> guests;

    @ManyToMany
    @JoinColumn(name = "room_id")
    private Room room;
    @ManyToOne
    @JoinColumn(name = "receptionist_id")
    private Receptionist receptionist;
}
package com.ua.robot.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "rooms")
@DynamicInsert
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    @Column
    private String type;
    @Column
    private int capacity;
    @Column
    private Long roomPrice;
    @Column
    private String description;

    @OneToMany(mappedBy = "room_id")
    private List<Reservation> reservations;

}

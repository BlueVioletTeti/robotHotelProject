package com.ua.robot.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table
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

    private List<Room> checkRoomAvailability(List<Room> rooms, LocalDate getArrivalDate, LocalDate getDepartureDate) {
//        for(int i=0; i<rooms.size(); i++){
//            rooms[i]
//        }
        return null;
    }

    private void bookRoom() {
//        if(room is available){
//           Reservation reservation = new Reservation();
//        }else{
//            throw exception?
//        }
    }
}

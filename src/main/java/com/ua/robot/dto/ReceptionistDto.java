package com.ua.robot.dto;

import com.ua.robot.domain.Guest;
import com.ua.robot.domain.Reservation;
import com.ua.robot.domain.Room;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class ReceptionistDto {
    private Long id;
    private String name;
    private int phoneNumber;
    private List<Reservation> reservations;
    private List<Room> rooms;
    private List<Guest> guests;
}

package com.ua.robot.dto;

import com.ua.robot.domain.Receptionist;
import com.ua.robot.domain.Reservation;

import java.util.List;

public class RoomDto {
    private Long id;
    private String type;
    private int capacity;
    private Long roomPrice;
    private String description;
    private List<Reservation> reservations;
    private Receptionist receptionist;
}

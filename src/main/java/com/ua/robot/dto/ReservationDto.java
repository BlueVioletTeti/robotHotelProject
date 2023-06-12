package com.ua.robot.dto;

import com.ua.robot.domain.Guest;
import com.ua.robot.domain.Room;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReservationDto {
    private Long id;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String guest;
    private String room;
}

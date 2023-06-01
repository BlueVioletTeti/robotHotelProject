package com.ua.robot.dto;

import com.ua.robot.domain.Reservation;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GuestDto {

    private Long id;
    private String guestName;
    private String guestSurname;
    private int passportId;
    private int phoneNumber;
    private String address;
//    private List<Reservation> reservations;
}
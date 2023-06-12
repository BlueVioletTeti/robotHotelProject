package com.ua.robot.dto;

import com.ua.robot.domain.Reservation;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class RoomDto {
    private Long id;
    private String type;
    private int capacity;
    private Long roomPrice;
    private String description;
}

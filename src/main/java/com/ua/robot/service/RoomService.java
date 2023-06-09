package com.ua.robot.service;

import com.ua.robot.domain.Room;
import com.ua.robot.dto.RoomDto;
import com.ua.robot.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

   private static RoomDto buildRoomDto(Room room) {
        return RoomDto.builder()
                .id(room.getRoomId())
                .type(room.getType())
                .capacity(room.getCapacity())
                .roomPrice(room.getRoomPrice())
                .description(room.getDescription())
                .build();
    }

    public List<RoomDto> findAll() {
        return roomRepository.findAll()
                .stream()
                .map(RoomService::buildRoomDto)
                .collect(Collectors.toList());
    }
    public List<RoomDto> findRoomsNotReservationListInRange(LocalDate arrivalDate, LocalDate departureDate) {
        List<Room> rooms = roomRepository.findRoomsNotReservationListInRange(arrivalDate, departureDate);
        List<RoomDto> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            RoomDto roomDto = RoomDto.builder()
                    .id(room.getRoomId())
                    .type(room.getType())
                    .capacity(room.getCapacity())
                    .roomPrice(room.getRoomPrice())
                    .description(room.getDescription())
                    .build();
            availableRooms.add(roomDto);
        }
        return availableRooms;
    }
    public Optional<RoomDto> findById(Long id) {
        return roomRepository.findById(id).map(RoomService::buildRoomDto);
    }
    public Optional<Room> findByIdUpdate(Long id) {
        return roomRepository.findById(id);
    }
    public void save(Room room) {
        roomRepository.save(room);
    }
    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }

}

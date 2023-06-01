package com.ua.robot.service;

import com.ua.robot.domain.Room;
import com.ua.robot.dto.RoomDto;
import com.ua.robot.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public List<RoomDto> findAll() {
//        return roomRepository.findAll()
//                .stream()
//                .map(GuestService::buildRoomDto)
//                .collect(Collectors.toList());
        return null;
    }

    private static RoomDto buildRoomDto(Room room) {
//        return GuestDto.builder()
//                .id(room.getId())
//                .name(room.getGuestName())
//                .reservationsId(room.getReservations().stream()
//                        .map(Room::getRoomType)
//                        .collect(Collectors.toList()))
//                .build();
        return null;
    }

    public Optional<Room> findById(Long id) {
//        return roomRepository.findById(id);
        return null;
    }

    public void save(Room room) {
//        roomRepository.save(room);
    }
}

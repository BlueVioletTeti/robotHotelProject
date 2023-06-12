package com.ua.robot.rest;

import com.ua.robot.domain.Room;
import com.ua.robot.dto.RoomDto;
import com.ua.robot.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RoomController {
    @Autowired
    private final RoomService roomService;

    @PostMapping("/rooms")
    public ResponseEntity<Void> save(@RequestBody Room room) {
        roomService.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/rooms")
    public ResponseEntity<List<RoomDto>> findAll() {
        return ResponseEntity.ok(roomService.findAll());
    }
    @GetMapping("/rooms/{id}")
    public Optional<RoomDto> findById(@PathVariable Long id) {
        return roomService.findById(id);
    }
    @DeleteMapping("/rooms/{id}")
    public void deleteRoom(@PathVariable(value = "id") Long id) {
        roomService.deleteById(id);
    }
    @GetMapping("/rooms/available/all")
    public List<RoomDto> getAvailableRooms
            (@RequestParam("arrivalDate")
             LocalDate arrivalDate,
             @RequestParam("departureDate")
             LocalDate departureDate) {
        return roomService.findRoomsNotReservationListInRange(arrivalDate, departureDate);
    }
    @PutMapping("/rooms/{id}")
    public ResponseEntity<Void> updateRoom(@PathVariable("id") Long id, @RequestBody RoomDto roomDto) {
        Optional<Room> optionalRoom = roomService.findByIdUpdate(id);
        if (optionalRoom.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Room room = optionalRoom.get();
        room.setType(roomDto.getType());
        room.setCapacity(roomDto.getCapacity());
        room.setRoomPrice(roomDto.getRoomPrice());
        room.setDescription(roomDto.getDescription());
        roomService.save(room);
        return ResponseEntity.ok().build();
    }
}

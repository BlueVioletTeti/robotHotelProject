package com.ua.robot.rest;

import com.ua.robot.domain.Room;
import com.ua.robot.dto.RoomDto;
import com.ua.robot.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping("/rooms")
    public void save(@RequestBody Room room) {
        roomService.save(room);
    }

    @GetMapping("/rooms")
    public List<RoomDto> findAll() {

        return roomService.findAll();
    }

}

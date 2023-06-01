package com.ua.robot.rest;

import com.ua.robot.domain.Receptionist;
import com.ua.robot.service.ReceptionistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReceptionistController {
    private final ReceptionistService receptionistService;

    @GetMapping("/receptionists")
    public List<Receptionist> findAll() {
        return receptionistService.findAll();
    }
}

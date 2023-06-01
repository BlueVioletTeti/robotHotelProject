package com.ua.robot.rest;

import com.ua.robot.domain.Reservation;
import com.ua.robot.dto.ReservationDto;
import com.ua.robot.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/reservations")
    public void save(@RequestBody Reservation reservation) {
        reservationService.save(reservation);
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationDto>> findAll() {

        return ResponseEntity.ok(reservationService.findAll());
    }

    @PostMapping("/reservations/{id}/guests/{guestId}")
    public ResponseEntity<Void> update(@PathVariable Long id, @PathVariable Long guestId) {
        reservationService.addGuest(id, guestId);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}

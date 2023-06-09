package com.ua.robot.rest;

import com.ua.robot.domain.Reservation;
import com.ua.robot.dto.ReservationDto;
import com.ua.robot.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    @Autowired
    private final ReservationService reservationService;

    @PostMapping("/reservations")
    public ResponseEntity<Void> save(@RequestBody Reservation reservation) {
        reservationService.save(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationDto>> findAll() {

        return ResponseEntity.ok(reservationService.findAll());
    }

//    @PostMapping("/reservations/{id}/guests/{guestId}")
//    public ResponseEntity<Void> updateGuestList(@PathVariable Long id, @PathVariable Long guestId) {
//        reservationService.addGuest(id, guestId);
//
//        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
//    }


    @PostMapping("/reservations/{id}/rooms/{roomId}")
    public ResponseEntity<Void> changeRoom(@PathVariable Long roomId, @PathVariable Long reservationId) {
        reservationService.changeRoom(roomId, reservationId);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/reservation/{reservationId}")
    public void delete(@PathVariable Long reservationId) {
        reservationService.deleteById(reservationId);
    }


}

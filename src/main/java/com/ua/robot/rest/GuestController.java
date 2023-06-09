package com.ua.robot.rest;

import com.ua.robot.domain.Guest;
import com.ua.robot.dto.GuestDto;
import com.ua.robot.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GuestController {
    @Autowired
    private final GuestService guestService;

    @PostMapping("/guests")
    public ResponseEntity<Void> save(@RequestBody Guest guest) {
        guestService.save(guest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/guests")
    public ResponseEntity<List<GuestDto>> findAll() {

        return ResponseEntity.ok(guestService.findAll());
    }
    @GetMapping("/guests/passportId/{passportId}")
    public ResponseEntity<GuestDto> findByPassportId(@PathVariable int passportId) {
        try{
            return ResponseEntity.ok(guestService.findByPassportId(passportId));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/guests/guestSurname/{guestSurname}")
    public ResponseEntity<GuestDto> findBySurname(@PathVariable String guestSurname) {
        try{
            return ResponseEntity.ok(guestService.findBySurname(guestSurname));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/guests/{id}")
    public ResponseEntity<Void> updateClient(
            @PathVariable("id") Long id,
            @RequestBody GuestDto guestDto) {
        Guest guest = guestService.findById(id);
        if (guest == null) {
            return ResponseEntity.notFound().build();
        }
        guest.setGuestName(guestDto.getGuestName());
        guest.setGuestSurname(guestDto.getGuestSurname());
        guest.setPassportId(guestDto.getPassportId());
        guest.setPhoneNumber(guestDto.getPhoneNumber());
        guest.setAddress(guestDto.getAddress());
        guestService.save(guest);
        return ResponseEntity.ok().build();
    }

}

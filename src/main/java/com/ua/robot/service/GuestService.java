package com.ua.robot.service;

import com.ua.robot.domain.Guest;
import com.ua.robot.dto.GuestDto;
import com.ua.robot.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;

    public List<GuestDto> findAll() {
        return guestRepository.findAll()
                .stream()
                .map(GuestService::buildGuestDto)
                .collect(Collectors.toList());
    }

    private static GuestDto buildGuestDto(Guest guest) {
//        return GuestDto.builder()
//                .id(guest.getId())
//                .name(guest.getGuestName())
//                .surname(guest.getGuestSurname())
//                .reservationsId(guest.getReservations().stream()
//                        .map(Reservation::getGuestSurname)
//                        .collect(Collectors.toList()))
//                .build();
        return null;
    }

    public Optional<Guest> findById(Long id) {
        return guestRepository.findById(id);
    }

    public void save(Guest guest) {
        guestRepository.save(guest);
    }
}

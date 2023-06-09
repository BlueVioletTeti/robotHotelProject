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
        return GuestDto.builder()
                .id(guest.getId())
                .guestName(guest.getGuestName())
                .guestSurname(guest.getGuestSurname())
                .passportId(guest.getPassportId())
                .phoneNumber(guest.getPhoneNumber())
                .address(guest.getAddress())
                .reservations(guest.getReservations()
                        .stream()
                        .map(reservation ->reservation.getId())
                        .collect(Collectors.toList()))
                .build();
    }

    public Guest findById(Long id) {
        return guestRepository.findById(id).get();
    }

    public void save(Guest guest) {
        guestRepository.save(guest);
    }

    public GuestDto findByPassportId(int passportId) {
        return buildGuestDto(guestRepository.findByPassportId(passportId));
    }

    public GuestDto findBySurname(String guestSurname) {
        return buildGuestDto(guestRepository.findBySurname(guestSurname));
    }
}

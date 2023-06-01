package com.ua.robot.service;

import com.ua.robot.domain.Reservation;
import com.ua.robot.dto.ReservationDto;
import com.ua.robot.repository.ReservationRepository;
import com.ua.robot.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;

    public List<ReservationDto> findAll() {
        return reservationRepository.findAll().stream()
                .map(ReservationService::buildReservationDto)
                .collect(Collectors.toList());

    }

    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    private static ReservationDto buildReservationDto(Reservation reservation) {
        var guestName = "NO ONE";
//        if (reservation.getGuest() != null) {
//            guestName = reservation.getGuest().getGuestName();
//        }
//        return ReservationDto.builder()
//                .id(reservation.getId())
//                .name(reservation.getGuestName())
//                .passportId(reservation.getPassportId())
//                .phoneNumber(reservation.getPhoneNumber())
//                .name(guestName)
//                .build();
        return null;
    }

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void addGuest(Long reservationId, Long guestId) {
        var guest = guestRepository.findById(guestId).get();
        var reservation = reservationRepository.findById(reservationId).get();
//        reservation.setGuest(guest);

        reservationRepository.save(reservation);
    }
}

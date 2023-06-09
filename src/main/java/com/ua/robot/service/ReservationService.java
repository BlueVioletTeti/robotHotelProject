package com.ua.robot.service;

import com.ua.robot.domain.Guest;
import com.ua.robot.domain.Reservation;
import com.ua.robot.dto.ReservationDto;
import com.ua.robot.repository.ReservationRepository;
import com.ua.robot.repository.GuestRepository;
import com.ua.robot.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {
    @Autowired
    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;

    public List<ReservationDto> findAll() {
        return reservationRepository.findAll().stream()
                .map(ReservationService::buildReservationDto)
                .collect(Collectors.toList());

    }

//    public Optional<Reservation> findById(Long id) {
//        return reservationRepository.findById(id);
//    }

    private static ReservationDto buildReservationDto(Reservation reservation) {
        return ReservationDto.builder()
                .id(reservation.getId())
                .arrivalDate(reservation.getArrivalDate())
                .departureDate(reservation.getDepartureDate())
                .room(reservation.getRoom())
                .guest((Guest) reservation.getGuests())
                .build();
    }

    private boolean isReservationExists(Reservation reservation) {
        return reservationRepository.existsByRoomAndArrivalDateAndDepartureDate(
                reservation.getRoom(), reservation.getArrivalDate(), reservation.getDepartureDate());
    }

    public void save(Reservation reservation) {
        if (isReservationExists(reservation)) {
            throw new IllegalArgumentException("Reservation already exists");
        } else {
            reservationRepository.save(reservation);
        }
    }

//    public void addGuest(Long reservationId, Long guestId) {
//        var guest = guestRepository.findById(guestId).get();
//        var reservation = reservationRepository.findById(reservationId).get();
//        reservation.setGuests(guest.setGuestName());
//
//        reservationRepository.save(reservation);
//    }



    public void changeRoom(Long roomId, Long reservationId) {
        var reservation = reservationRepository.findById(reservationId).get();
        var room = roomRepository.findById(roomId).get();
        reservation.setRoom(room);

        if (isReservationExists(reservation)) {
            throw new IllegalArgumentException("Reservation already exists");

        } else {
            reservationRepository.save(reservation);
        }
    }

    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }
}

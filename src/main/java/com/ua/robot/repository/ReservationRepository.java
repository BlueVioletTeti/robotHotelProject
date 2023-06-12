package com.ua.robot.repository;

import com.ua.robot.domain.Reservation;
import com.ua.robot.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT case when COUNT (c) > 0 FROM reservation WHERE room_id = : room.id AND " +
            "(arrival_date < :arrival_date AND departure_date > :arrival_date) OR " +
            "(arrival_date < :departure_date AND departure_date > :departure_date) " +
            "OR (:arrival_date BETWEEN arrival_date and departure_date) OR " +
            "(:departure_date BETWEEN arrival_date AND departure_date)")
    boolean existsByRoomAndArrivalDateAndDepartureDate(
            @Param("room") Room room,
            @Param("arrival_date") LocalDate start,
            @Param("departure_date") LocalDate end);
}

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
    @Query("select case when count (c) > 0 from reservation where room_id = : room.id and " +
            "(start_date < :start_date and end_date > :start_date) or " +
            "(start_date < :end_date and end_date > :end_date) " +
            "or (:start_date between start_date and end_date) or " +
            "(:end_date between start_date and end_date)")
    boolean existsByRoomAndArrivalDateAndDepartureDate(
            @Param("room") Room room,
            @Param("start_date") LocalDate start,
            @Param("end_date") LocalDate end);
}

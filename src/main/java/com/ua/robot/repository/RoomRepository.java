package com.ua.robot.repository;

import com.ua.robot.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT *  FROM rooms WHERE rooms.id NOT IN (SELECT reservations.room_id FROM " +
            "reservations WHERE reservations.arrival_date <= :departure_date AND " +
            "reservations.departure_date >= :arrival_date)")
    List<Room> findRoomsNotReservationListInRange(
            @Param("arrival_date") LocalDate arrivalDate,
            @Param("departure_date") LocalDate departureDate);


    Optional<Room> findById(Long id);
}

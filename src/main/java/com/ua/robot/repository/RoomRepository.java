package com.ua.robot.repository;

import com.ua.robot.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT * FROM rooms\n" +
            "WHERE rooms.id NOT IN\n" +
            "(SELECT * FROM rooms\n" +
            "       LEFT JOIN reservations ON rooms.id = reservations.room_id\n" +
            "       UNION\n" +
            "       SELECT * FROM rooms\n" +
            "       RIGHT JOIN reservations ON rooms.id = reservations.room_id" +
            "       WHERE reservations.arrivalDate >= ?(arrivalDate) AND " +
            "reservations.departureDate <=? (departureDate)\n" +
            ";")
    List<Room> findAllAvailableReservations(LocalDate arrivalDate, LocalDate departureDate);
}

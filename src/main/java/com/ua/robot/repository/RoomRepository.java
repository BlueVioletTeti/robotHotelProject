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
//    @Query("SELECT * FROM rooms\n" +
//            "WHERE rooms.id NOT IN\n" +
//            "(SELECT * FROM rooms\n" +
//            "       LEFT JOIN reservations ON rooms.id = reservations.room_id\n" +
//            "       UNION\n" +
//            "       SELECT * FROM rooms\n" +
//            "       RIGHT JOIN reservations ON rooms.id = reservations.room_id" +
//            "       WHERE reservations.arrivalDate >= ?(arrivalDate) AND " +
//            "reservations.departureDate <=? (departureDate)\n" +
//            ";")
//    List<Room> findAllAvailableReservations(LocalDate arrivalDate, LocalDate departureDate);

    @Query("SELECT *  FROM rooms WHERE rooms.id NOT IN (SELECT reservations.room_id FROM " +
            "reservations WHERE reservations.arrivalDate <= :departureDate AND " +
            "reservations.departureDate >= :arrivalDate)")
    List<Room> findRoomsNotReservationListInRange(
            @Param("arrivalDate") LocalDate arrivalDate,
            @Param("checkOut") LocalDate departureDate);


    Optional<Room> findById(Long id);
}

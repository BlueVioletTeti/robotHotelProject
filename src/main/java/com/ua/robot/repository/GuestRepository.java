package com.ua.robot.repository;

import com.ua.robot.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    Guest findBySurname(String guestSurname);
    Guest findByPassportId(int passportId);

}

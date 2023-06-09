package com.ua.robot.repository;

import com.ua.robot.domain.Guest;
import com.ua.robot.domain.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist, Long> {
    Receptionist findByName(String name);
}

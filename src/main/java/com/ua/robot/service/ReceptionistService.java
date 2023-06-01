package com.ua.robot.service;

import com.ua.robot.domain.Receptionist;
import com.ua.robot.repository.ReceptionistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReceptionistService {
    private final ReceptionistRepository receptionistRepository;

    public List<Receptionist> findAll() {
        return receptionistRepository.findAll();

    }

    public Optional<Receptionist> findById(Long id) {
        return receptionistRepository.findById(id);
    }

    public void save(Receptionist receptionist) {
        receptionistRepository.save(receptionist);
    }


}

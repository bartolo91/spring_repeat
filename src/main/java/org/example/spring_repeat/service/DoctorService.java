package org.example.spring_repeat.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.spring_repeat.exceptions.types.EntityNotFoundException;
import org.example.spring_repeat.model.Doctor;
import org.example.spring_repeat.model.command.CreateDoctorCommand;
import org.example.spring_repeat.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public Doctor create(@Valid CreateDoctorCommand command) {
        return doctorRepository.saveAndFlush(Doctor.builder()
                .name(command.getName())
                .birthCity(command.getBirthCity())
                .nip(command.getNip())
                .specialization(command.getSpecialization())
                .experience(command.getExperience())
                .visits(new HashSet<>())
                .build());
    }

    public Doctor findById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Doctor.class, id));
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}

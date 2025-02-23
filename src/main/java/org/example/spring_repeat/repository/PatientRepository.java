package org.example.spring_repeat.repository;

import org.example.spring_repeat.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}

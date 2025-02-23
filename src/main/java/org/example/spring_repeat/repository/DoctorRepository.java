package org.example.spring_repeat.repository;


import org.example.spring_repeat.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}

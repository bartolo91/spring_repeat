package org.example.spring_repeat.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.spring_repeat.model.Doctor;
import org.example.spring_repeat.model.command.CreateDoctorCommand;
import org.example.spring_repeat.model.dto.DoctorDto;
import org.example.spring_repeat.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity createDoctor(@RequestBody @Valid CreateDoctorCommand command) {
        Doctor createdDoctor = doctorService.create(command);
        DoctorDto doctorDTO = modelMapper.map(createdDoctor, DoctorDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity getSingleDoctor(@PathVariable Long id) {
        Doctor createdDoctor = doctorService.findById(id);
        DoctorDto doctorDto = modelMapper.map(createdDoctor, DoctorDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(doctorDto);
    }

    @GetMapping
    public ResponseEntity getAllDoctors(){
        List<Doctor> doctors = doctorService.getAllDoctors();
        List<DoctorDto> doctorDtos = doctors.stream().map(doctor -> modelMapper.map(doctor, DoctorDto.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(doctorDtos);
    }
}

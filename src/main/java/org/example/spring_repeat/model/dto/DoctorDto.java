package org.example.spring_repeat.model.dto;

import lombok.Value;

@Value
public class DoctorDto {

    Long id;
    String specialization;
    String name;
    int experience;
    String birthCity;
    String nip;
    int amountOfVisits;

}

package org.example.spring_repeat.model.dto;

import lombok.Value;

@Value
public class PatientDto {

    Long id;
    String name;
    String birthCity;
    int age;
    int amountOfVisits;

 }

package org.example.spring_repeat.model.command;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateDoctorCommand {

    //@OneFromDictionary(name = "DOCTOR_SPECIALIZATIONS", message = "UNKNOWN_SPECIALIZATION");
    private String specialization;
    @NotEmpty(message = "NAME_NOT_EMPTY")
    private String name;
    @Positive(message = "EXPERIENCE_NOT_NEGATIVE")
    private int experience;
    @NotEmpty(message = "BIRTH_CITY_NOT_EMPTY")
    private String birthCity;
    // @UniqueNip(message = "NIP_NOT"UNIQUE")
    @NotEmpty(message = "NIP_NOT_EMPTY")
    private String nip;

}

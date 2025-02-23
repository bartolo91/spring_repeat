package org.example.spring_repeat.model.command;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreatePatientCommand {

    @NotEmpty(message = "NAME_NOT_EMPTY")
    private String name;
    @NotEmpty(message = "BIRTH_CITY_NOT_EMPTY")
    private String birthCity;
    @Positive(message = "AGE_NOT_NEGATIVE")
    @NotEmpty(message = "AGE_NOT_EMPTY")
    private int age;
    // @UniqueEmail(message = "E-MAIL_NOT"UNIQUE")
    @NotEmpty(message = "E-MAIL_NOT_EMPTY")
    private String email;
    // @UniquePesel(message = "PESEL_NOT"UNIQUE")
    @NotEmpty(message = "PESEL_NOT_EMPTY")
    private String pesel;

}

package org.example.spring_repeat.model.command;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.spring_repeat.validation.annotation.CheckId;
import org.example.spring_repeat.model.Doctor;
import org.example.spring_repeat.model.Patient;
import org.example.spring_repeat.repository.DoctorRepository;
import org.example.spring_repeat.repository.PatientRepository;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateVisitCommand {

    @NotNull(message = "DOCTOR_ID_NOT_NULL")
    @CheckId(message = "DOCTOR_ID_NOT_EXIST", type = Doctor.class, repository = DoctorRepository.class)
    private Long doctorId;
    @NotNull(message = "PATIENT_ID_NOT_NULL")
    @CheckId(message = "PATIENT_ID_NOT_EXIST", type = Patient.class, repository = PatientRepository.class)
    private Long patientId;
    @NotNull(message = "DATE_NOT_NULL")
    @FutureOrPresent(message = "DATE_NOT_PAST")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime visitDate;
    @NotNull(message = "LENGTH_NOT_NULL")
    @Min(value = 10, message = "LENGTH_TOO_SHORT")
    private Integer length;
    @NotNull(message = "PRICE_NOT_NULL")
    @Min(value = 0, message = "PRICE_NOT_NEGATIVE")
    private Integer price;

}

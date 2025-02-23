package org.example.spring_repeat.config.converters;

import org.example.spring_repeat.model.Patient;
import org.example.spring_repeat.model.dto.PatientDto;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

@Service
public class PatientToPatientDtoConverter implements Converter<Patient, PatientDto> {

    @Override
    public PatientDto convert(MappingContext<Patient, PatientDto> context) {
        Patient patient = context.getSource();
        return new PatientDto(patient.getId(),
                patient.getName(),
                patient.getBirthCity(),
                patient.getAge(),
                patient.getVisits().size());
    }

}

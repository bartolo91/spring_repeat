package org.example.spring_repeat.config.converters;

import org.example.spring_repeat.model.Doctor;
import org.example.spring_repeat.model.dto.DoctorDto;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

@Service
public class DoctorToDoctorDtoConverter implements Converter<Doctor, DoctorDto> {

    @Override
    public DoctorDto convert(MappingContext<Doctor, DoctorDto> context) {
        Doctor doctor = context.getSource();
        return new DoctorDto(doctor.getId(),
                doctor.getName(),
                doctor.getBirthCity(),
                doctor.getExperience(),
                doctor.getSpecialization(),
                doctor.getNip(),
                doctor.getVisits().size());
    }

}

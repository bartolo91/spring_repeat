package org.example.spring_repeat.model.dto;

import java.time.LocalDateTime;

public class VisitDto {

    private Long id;
    private Long doctorId; // można dać imiona np...
    private Long patientId;
    private LocalDateTime visitDate;
    private int length;
    private int price;
}

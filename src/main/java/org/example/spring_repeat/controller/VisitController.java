package org.example.spring_repeat.controller;

import jakarta.validation.Valid;
import org.example.spring_repeat.model.command.CreateVisitCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/visits")
public class VisitController {

    @PostMapping
    public ResponseEntity saveVisit(@RequestBody @Valid CreateVisitCommand command) {
        return null;
    }
}

package org.example.spring_repeat.model;


import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String birthCity;
    private int age;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String pesel;

    @OneToMany(mappedBy = "patient")
    private Set<Visit> visits = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return age == patient.age && Objects.equals(id, patient.id) && Objects.equals(name, patient.name) && Objects.equals(birthCity, patient.birthCity) && Objects.equals(email, patient.email) && Objects.equals(pesel, patient.pesel) && Objects.equals(visits, patient.visits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthCity, age, email, pesel, visits);
    }
}

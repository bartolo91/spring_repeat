package org.example.spring_repeat.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckIdValidator implements ConstraintValidator<CheckId, Long> {

    private final WebApplicationContext applicationContext;
    private JpaRepository<?, Long> repository;
    private Class<?> type;

    @Override
    public void initialize(CheckId constraintAnnotation) {
        repository = applicationContext.getBean(constraintAnnotation.repository());
        type = constraintAnnotation.type();
    }

    @Override
    public boolean isValid(Long entityId, ConstraintValidatorContext constraintValidatorContext) {
        return Optional.ofNullable(entityId)
                .map(id -> repository.existsById(id))
                .orElse(true);
    }

}

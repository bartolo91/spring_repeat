package org.example.spring_repeat.exceptions.types;

import lombok.Value;

@Value
public class EntityNotFoundException extends RuntimeException{

    private Class<?> type;
    private Long id;
}

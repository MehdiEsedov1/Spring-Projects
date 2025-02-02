package com.example.user_manegement_system.model.exception;

import com.example.user_manegement_system.enums.Exceptions;
import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {
    private final Exceptions exceptions;

    public ApplicationException(Exceptions exceptions) {
        super(exceptions.getMessage());
        this.exceptions = exceptions;
    }
}

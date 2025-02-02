package com.example.ecommerce.model.exceptions;

import com.example.ecommerce.model.enums.Exceptions;
import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {
    private final Exceptions e;

    public ApplicationException(Exceptions e) {
        super(e.getMessage());
        this.e = e;
    }
}
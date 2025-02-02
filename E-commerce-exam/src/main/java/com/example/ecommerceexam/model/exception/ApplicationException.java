package com.example.ecommerceexam.model.exception;

import com.example.ecommerceexam.model.enums.Exception;

public class ApplicationException extends RuntimeException {
    public Exception exc;

    public ApplicationException(Exception exc) {
        super(exc.message);
        this.exc = exc;
    }
}
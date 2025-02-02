package com.example.ecommerceexam.model.enums;

import org.springframework.http.HttpStatus;

public enum Exception {
    PRODUCT_NOTFOUND("Product doesn't exist", HttpStatus.NOT_FOUND);
    public final String message;
    public final HttpStatus status;

    Exception(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
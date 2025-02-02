package com.example.ecommerce.model.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Exceptions {
    CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "Category not found!!!"),
    SUPPLIER_NOT_FOUND(HttpStatus.NOT_FOUND, "Supplier not found!!!"),
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "Product not found!!!");

    private final HttpStatus status;
    private final String message;

    Exceptions(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
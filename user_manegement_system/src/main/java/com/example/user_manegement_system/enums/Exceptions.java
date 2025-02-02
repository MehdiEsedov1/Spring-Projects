package com.example.user_manegement_system.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public enum Exceptions {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found!"),
    TOKEN_NOT_FOUND(HttpStatus.NOT_FOUND, "Token not found!");

    private final HttpStatus status;
    private final String message;
    private final LocalDateTime time = LocalDateTime.now().withNano(0);

    Exceptions(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
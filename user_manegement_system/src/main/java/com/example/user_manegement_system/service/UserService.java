package com.example.user_manegement_system.service;

import com.example.user_manegement_system.model.dto.request.UserRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Void> registration(UserRequest userRequest);

    ResponseEntity<Void> confirmation(String token);
}

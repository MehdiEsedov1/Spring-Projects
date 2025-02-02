package com.example.user_manegement_system.controller;

import com.example.user_manegement_system.model.dto.request.UserRequest;
import com.example.user_manegement_system.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "User Controller", description = "User Controller description")
public class UserController {
    private final UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<Void> registration(@RequestBody @Valid UserRequest request) {
        return userService.registration(request);
    }

    @PostMapping("/confirmation")
    public ResponseEntity<Void> confirmation(@RequestParam String token) {
        return userService.confirmation(token);
    }
}
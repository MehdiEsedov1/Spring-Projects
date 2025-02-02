package com.example.ecommerceexam.controller;

import com.example.ecommerceexam.model.dto.request.UserRequest;
import com.example.ecommerceexam.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "user")
public class UserController {
    private final UserService userService;

    @PostMapping(path = "/logIn")
    void logIn(@RequestBody @Valid UserRequest userRequest) {
        userService.logIn(userRequest);
    }

    @PostMapping(path = "/signUp")
    void signUp(@RequestBody @Valid UserRequest userRequest) {
        userService.signUp(userRequest);
    }
}
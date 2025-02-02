package com.example.ecommerceexam.service;

import com.example.ecommerceexam.model.dto.request.UserRequest;

public interface UserService {
    String logIn(UserRequest userRequest);

    String signUp(UserRequest userRequest);
}
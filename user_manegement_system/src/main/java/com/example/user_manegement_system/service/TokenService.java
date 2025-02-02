package com.example.user_manegement_system.service;

import com.example.user_manegement_system.model.entity.Token;

public interface TokenService {
    Token getToken(String token);
}

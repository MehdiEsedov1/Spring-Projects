package com.example.user_manegement_system.helper;

import com.example.user_manegement_system.model.entity.Token;
import com.example.user_manegement_system.model.entity.Users;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenHelper {
    public Token getConfirmationTokenBuild(Users user) {
        String token = UUID.randomUUID().toString();

        return Token
                .builder()
                .user(user)
                .token(token)
                .build();
    }
}
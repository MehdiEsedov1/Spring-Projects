package com.example.user_manegement_system.service.impl;

import com.example.user_manegement_system.enums.Exceptions;
import com.example.user_manegement_system.model.entity.Token;
import com.example.user_manegement_system.model.exception.ApplicationException;
import com.example.user_manegement_system.repository.TokenRepository;
import com.example.user_manegement_system.service.TokenService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    private final TokenRepository tokenRepository;

    @Override
    @Transactional
    public Token getToken(String token) {
        return tokenRepository.findByToken(token)
                .orElseThrow(() -> new ApplicationException(Exceptions.TOKEN_NOT_FOUND));
    }
}
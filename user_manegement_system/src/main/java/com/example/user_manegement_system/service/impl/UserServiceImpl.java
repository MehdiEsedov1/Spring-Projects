package com.example.user_manegement_system.service.impl;

import com.example.user_manegement_system.helper.EmailServiceHelper;
import com.example.user_manegement_system.helper.TokenHelper;
import com.example.user_manegement_system.mapper.UserMapper;
import com.example.user_manegement_system.model.dto.request.EmailRequest;
import com.example.user_manegement_system.model.dto.request.UserRequest;
import com.example.user_manegement_system.model.entity.Token;
import com.example.user_manegement_system.model.entity.Users;
import com.example.user_manegement_system.repository.TokenRepository;
import com.example.user_manegement_system.repository.UserRepository;
import com.example.user_manegement_system.service.EmailService;
import com.example.user_manegement_system.service.TokenService;
import com.example.user_manegement_system.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final TokenService tokenService;
    private final EmailService emailService;
    private final EmailServiceHelper emailServiceHelper;
    private final TokenHelper tokenHelper;
    private final TokenRepository confirmationTokenRepository;

    @Override
    public ResponseEntity<Void> registration(UserRequest request) {
        Users user = userMapper.map(request);
        userRepository.save(user);

        Token confirmationToken = tokenHelper.getConfirmationTokenBuild(user);
        confirmationTokenRepository.save(confirmationToken);

        EmailRequest emailRequest = emailServiceHelper.sendEmailToVerify(user, confirmationToken.getToken());
        emailService.sendEmail(emailRequest);

        return ResponseEntity.noContent().build();
    }

    @Override
    @Transactional
    public ResponseEntity<Void> confirmation(String token) {
        Token confirmationToken = tokenService.getToken(token);

        Users user = confirmationToken.getUser();
        user.setIsEnable(true);

        return ResponseEntity.noContent().build();
    }
}
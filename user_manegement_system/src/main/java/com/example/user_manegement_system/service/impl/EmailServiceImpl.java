package com.example.user_manegement_system.service.impl;

import com.example.user_manegement_system.model.dto.request.EmailRequest;
import com.example.user_manegement_system.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;

    @Override
    public void sendEmail(EmailRequest request) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("i.s.m3132005.az@gmail.com");
        mailMessage.setTo(request.getTo());
        mailMessage.setSubject(request.getSubject());
        mailMessage.setText(request.getText());

        mailSender.send(mailMessage);
    }
}
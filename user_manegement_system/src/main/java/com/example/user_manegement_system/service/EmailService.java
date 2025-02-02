package com.example.user_manegement_system.service;

import com.example.user_manegement_system.model.dto.request.EmailRequest;

public interface EmailService {
    void sendEmail(EmailRequest request);
}

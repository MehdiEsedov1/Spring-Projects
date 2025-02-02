package com.example.user_manegement_system.helper;

import com.example.user_manegement_system.enums.SubjectType;
import com.example.user_manegement_system.model.dto.request.EmailRequest;
import com.example.user_manegement_system.model.entity.Users;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

@Service
public class EmailServiceHelper {
    @Value("${application.mail.http")
    String http;

    @Value("localhost")
    String host;

    @Value("/user/confirmation?token=")
    String confirmation;

    @Value("${application.mail.reset-password}")
    String resetPassword;

    public EmailRequest sendEmailToVerify(Users user, String token) {
        String url = http + host + getServerPort() + confirmation + token;

        return EmailRequest.builder()
                .to(user.getEmail())
                .subject(SubjectType.REGISTRATION.name())
                .text("<p> Hi, " + user.getName() + ", </p>" +
                        "<p>Thank you for registering with us," +
                        "Please, follow the link below to complete your registration.</p>" +
                        "<a href=\"" + url + "\">Verify your email to active your account</a>" +
                        "<p> Thank you <br> Users Registration Portal Service</p>")
                .build();
    }

    private String getServerPort() {
        HttpServletRequest request = ((ServletRequestAttributes)
                Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getRequest();

        return ":" + request.getServerPort();
    }
}
package com.example.layeredArchitecture.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Open API",
        description = "Open API description",
        version = "1.0",
        contact = @Contact(
                name = "mehdiasadov",
                email = "i.s.m3132005@gmail.com",
                url = "www.mehdiasadov.com")
))
public class OpenAPIConfig {
}
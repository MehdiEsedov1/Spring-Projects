package com.example.ecommerce.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "E-commerce",
                description = "This is a e-commerce app.",
                version = "1.1.0",
                contact = @Contact(
                        name = "MehdiEsedov",
                        email = "mehdiesedof@gmail.com",
                        url = "mehdiesedov.com")
        ))
public class SwaggerConfig {
}
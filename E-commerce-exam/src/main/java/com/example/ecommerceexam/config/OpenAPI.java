package com.example.ecommerceexam.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Open API",
        description = "Open API desc",
        version = "1.0",
        contact = @Contact(
                name = "MehdiEsedov",
                email = "mehdiesedof@gmail.com",
                url = "mehdiesedov.com")
))
public class OpenAPI {
}
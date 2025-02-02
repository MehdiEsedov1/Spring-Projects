package com.example.ecommerceexam.model.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BrandRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @Pattern(
            regexp = "^(?=.*[a-zA-Z])(?=.*\\d{2}).{5,10}$",
            message = "password must be min 4 and max 12 length containing at least 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    private String name;
    @NotBlank
    @Size(min = 10, max = 30, message = "description must between 10 symbol and 30 symbol")
    private String description;
}
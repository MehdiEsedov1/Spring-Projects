package com.example.ecommerceexam.model.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @NotBlank
    @Size(min = 5, max = 10, message = "Symbols of name must between 5 and 10")
    private String name;
    @NotBlank
    @Size(min = 5, max = 15, message = "Symbols of name must between 5 and 10")
    private String surname;
    @NotBlank
    private String address;
    @NotBlank
    private String email;
    @NotBlank
    private String birthdate;
}
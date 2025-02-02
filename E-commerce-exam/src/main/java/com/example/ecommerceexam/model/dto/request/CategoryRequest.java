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
public class CategoryRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @NotBlank
    @Min(value = 5, message = "Name must contain minimum 10 symbol")
    @Max(value = 10, message = "Name must contain maximum 10 symbol")
    private String name;
    @NotNull
    @Size(min = 10, max = 30, message = "description must between 10 symbol and 30 symbol")
    private String description;
}

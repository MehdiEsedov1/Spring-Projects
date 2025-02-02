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
public class ProductRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @NotBlank
    @Min(value = 5, message = "Name must contain minimum 10 symbol")
    @Max(value = 10, message = "Name must contain maximum 10 symbol")
    private String name;
    @NotBlank
    @Size(min = 10, max = 30, message = "product details must be between 10 and 30 symbol")
    private String productDetails;
    @NotBlank
    @Size(min = 10, max = 30, message = "product details must be between 10 and 30 symbol")
    private String description;
    @NotNull
    private Integer amount;
    @NotNull
    private Integer remainCount;
    @NotNull
    private Long brandId;
    @NotNull
    private Long categoryId;
}
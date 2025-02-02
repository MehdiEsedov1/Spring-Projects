package com.example.ecommerce.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {
    private Long id;
    @Size(min = 5, max = 10, message = "number of symbols isn't correct!!!")
    private String name;
    @NotBlank(message = "description is blank")
    @NotNull(message = "description is null")
    private String description;
    private BigDecimal price;
    Long categoryId;
    Long supplierId;
}
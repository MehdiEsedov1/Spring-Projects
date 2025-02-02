package com.example.ecommerce.model.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    CategoryResponse category;
    SupplierResponse supplier;
}
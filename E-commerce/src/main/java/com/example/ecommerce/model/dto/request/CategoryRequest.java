package com.example.ecommerce.model.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryRequest {
    @Max(value = 10,message = "Name must contain min 10 character")
    @Min(value = 5,message = "Name must contain min 5 character")
    private String name;
}
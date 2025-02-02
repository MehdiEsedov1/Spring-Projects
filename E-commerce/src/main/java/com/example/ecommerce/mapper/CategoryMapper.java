package com.example.ecommerce.mapper;

import com.example.ecommerce.model.dto.request.CategoryRequest;
import com.example.ecommerce.model.dto.response.CategoryResponse;
import com.example.ecommerce.model.entity.Category;

public interface CategoryMapper {
    Category map(CategoryRequest categoryRequest);

    CategoryResponse map(Category category);
}

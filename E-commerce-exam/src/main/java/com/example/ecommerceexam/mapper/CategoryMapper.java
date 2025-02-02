package com.example.ecommerceexam.mapper;

import com.example.ecommerceexam.model.dto.request.CategoryRequest;
import com.example.ecommerceexam.model.dto.response.CategoryResponse;
import com.example.ecommerceexam.model.entity.Category;

public interface CategoryMapper {
    Category map(CategoryRequest categoryRequest);

    CategoryResponse map(Category category);
}
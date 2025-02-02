package com.example.ecommerce.mapper.impl;

import com.example.ecommerce.mapper.CategoryMapper;
import com.example.ecommerce.model.dto.request.CategoryRequest;
import com.example.ecommerce.model.dto.response.CategoryResponse;
import com.example.ecommerce.model.entity.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public Category map(CategoryRequest categoryRequest) {
        return Category.builder()
                .name(categoryRequest.getName())
                .build();
    }

    @Override
    public CategoryResponse map(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
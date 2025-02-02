package com.example.ecommerceexam.mapper.impl;

import com.example.ecommerceexam.mapper.CategoryMapper;
import com.example.ecommerceexam.model.dto.request.CategoryRequest;
import com.example.ecommerceexam.model.dto.response.CategoryResponse;
import com.example.ecommerceexam.model.entity.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public Category map(CategoryRequest categoryRequest) {
        return Category.builder()
                .name(categoryRequest.getName())
                .description(categoryRequest.getDescription())
                .build();
    }

    @Override
    public CategoryResponse map(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
}
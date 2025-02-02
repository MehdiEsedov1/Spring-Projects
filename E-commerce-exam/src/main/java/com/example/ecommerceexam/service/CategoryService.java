package com.example.ecommerceexam.service;

import com.example.ecommerceexam.model.dto.request.CategoryRequest;
import com.example.ecommerceexam.model.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();

    void addNewCategory(CategoryRequest categoryRequest);

    CategoryResponse getCategoryById(Long id);

    void updateCategoryById(Long id, CategoryRequest categoryRequest);
}
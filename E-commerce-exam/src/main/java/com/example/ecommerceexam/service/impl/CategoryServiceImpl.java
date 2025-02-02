package com.example.ecommerceexam.service.impl;

import com.example.ecommerceexam.mapper.CategoryMapper;
import com.example.ecommerceexam.model.dto.request.CategoryRequest;
import com.example.ecommerceexam.model.dto.response.CategoryResponse;
import com.example.ecommerceexam.model.entity.Category;
import com.example.ecommerceexam.repository.CategoryRepo;
import com.example.ecommerceexam.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        return categories
                .stream()
                .map(category -> categoryMapper.map(category))
                .collect(Collectors.toList());
    }

    @Override
    public void addNewCategory(CategoryRequest categoryRequest) {
        categoryRepo.save(categoryMapper.map(categoryRequest));
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        return categoryMapper.map(categoryRepo.findById(id).orElseThrow());
    }

    @Override
    public void updateCategoryById(Long id, CategoryRequest categoryRequest) {
        Category newCategory = categoryRepo.findById(id).orElseThrow();
        newCategory.setDescription(categoryRequest.getDescription());
        newCategory.setName(categoryRequest.getName());
        categoryRepo.save(newCategory);
    }
}
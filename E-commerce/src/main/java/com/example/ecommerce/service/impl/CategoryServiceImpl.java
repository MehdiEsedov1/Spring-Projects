package com.example.ecommerce.service.impl;

import com.example.ecommerce.mapper.CategoryMapper;
import com.example.ecommerce.model.dto.request.CategoryRequest;
import com.example.ecommerce.model.dto.response.CategoryResponse;
import com.example.ecommerce.model.entity.Category;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public ResponseEntity<Void> create(CategoryRequest request) {
        categoryRepository.save(categoryMapper.map(request));
        return ResponseEntity.noContent().build();
    }

    @Override
    public List<CategoryResponse> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories
                .stream()
                .map(category -> categoryMapper.map(category))
                .collect(Collectors.toList());
    }
}

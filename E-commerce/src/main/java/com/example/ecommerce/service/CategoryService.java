package com.example.ecommerce.service;

import com.example.ecommerce.model.dto.request.CategoryRequest;
import org.springframework.http.ResponseEntity;
import com.example.ecommerce.model.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> findAll();

    ResponseEntity<Void> create(CategoryRequest request);
}
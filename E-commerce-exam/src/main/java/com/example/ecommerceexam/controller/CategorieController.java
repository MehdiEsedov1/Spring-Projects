package com.example.ecommerceexam.controller;

import com.example.ecommerceexam.model.dto.request.CategoryRequest;
import com.example.ecommerceexam.model.dto.response.CategoryResponse;
import com.example.ecommerceexam.service.CategoryService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "category")
public class CategorieController {
    private final CategoryService categoryService;

    @GetMapping(path = "/getAllCategories")
    List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping(path = "/getCategoryById/{id}")
    CategoryResponse getCategory(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping(path = "/postCategory")
    void postCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        categoryService.addNewCategory(categoryRequest);
    }

    @PutMapping(path = "putCategoryById/{id}")
    void putCategoryById(@RequestBody @Valid CategoryRequest categoryRequest, @PathVariable Long id) {
        categoryService.updateCategoryById(id, categoryRequest);
    }
}
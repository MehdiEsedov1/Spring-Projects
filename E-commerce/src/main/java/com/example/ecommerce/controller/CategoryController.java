package com.example.ecommerce.controller;

import com.example.ecommerce.model.dto.request.CategoryRequest;
import com.example.ecommerce.model.dto.response.CategoryResponse;
import com.example.ecommerce.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Builder
@RequestMapping("/category")
//Bu OpenAPI da başlığları və onların açığlamalarını konfiqurasiya etmək üçündür.
@Tag(name = "Category", description = "This is controller about categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping(path = "/getCategory")
    public List<CategoryResponse> findAll() {
        return categoryService.findAll();
    }

    @PostMapping(path = "/postCategory")
    public ResponseEntity<Void> create(@RequestBody @Valid CategoryRequest request) {
        return categoryService.create(request);
    }

    //ResponseEntity ya da RequestEntity bunlar request ve responsları configure etmek üçündür.
    @GetMapping("/ResponseEntity-Example-0")
    ResponseEntity<String> customHeader() {
        //Burada biz custom header hazırlamışığ.
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "foo");
        //Burada isə body və statusu configure etmişik.
        return new ResponseEntity<>(
                "Custom header set", headers, HttpStatus.OK);
    }

    //Bu sadəcə fərqli sintaksislə yazılışıdır.
    @GetMapping("/ResponseEntity-Example-1")
    ResponseEntity<String> x() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Header0", "content of header");

        return ResponseEntity
                .status(200)
                .headers(headers)
                .body("There must be a content of body");
    }
}
package com.example.ecommerceexam.controller;

import com.example.ecommerceexam.model.dto.request.ProductRequest;
import com.example.ecommerceexam.model.dto.response.CategoryResponse;
import com.example.ecommerceexam.model.dto.response.ProductResponse;
import com.example.ecommerceexam.service.ProductService;
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
@RequestMapping(path = "product")
public class ProductController {
    private final ProductService productService;

    @GetMapping(path = "/getAllProducts")
    List<ProductResponse> getAllProducts(@RequestParam(required = false) Long brandId, @RequestParam(required = false) Long categoryId) {
        return productService.getAllProducts(categoryId, brandId);
    }

    @GetMapping(path = "/getProductsById/{id}")
    ProductResponse getProducts(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping(path = "/postProduct")
    void postProduct(@RequestBody @Valid ProductRequest productRequest) {
        productService.addNewProduct(productRequest);
    }

    @PutMapping(path = "putProductById/{id}")
    void putProductById(@RequestBody @Valid ProductRequest productRequest, @PathVariable Long id) {
        productService.updateProductById(id, productRequest);
    }
}
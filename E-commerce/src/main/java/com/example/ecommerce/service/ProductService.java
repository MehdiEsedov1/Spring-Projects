package com.example.ecommerce.service;

import com.example.ecommerce.model.dto.request.ProductRequest;
import com.example.ecommerce.model.dto.response.ProductResponse;
import com.example.ecommerce.model.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<Void> create(ProductRequest request);

    List<ProductResponse> findAll(Long categoryId);

    ProductResponse findById(Long id);

    ResponseEntity<Void> updateProductById(ProductRequest request, Long id);

    ResponseEntity<Void> deleteProductById(Long id);
}

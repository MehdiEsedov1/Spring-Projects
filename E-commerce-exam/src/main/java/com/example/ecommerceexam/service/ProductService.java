package com.example.ecommerceexam.service;

import com.example.ecommerceexam.model.dto.request.ProductRequest;
import com.example.ecommerceexam.model.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts(Long categoryId,Long brandId);

    void addNewProduct(ProductRequest productRequest);

    ProductResponse getProductById(Long id);

    void updateProductById(Long id, ProductRequest productRequest);
}
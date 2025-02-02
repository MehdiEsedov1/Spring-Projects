package com.example.ecommerceexam.mapper;

import com.example.ecommerceexam.model.dto.request.ProductRequest;
import com.example.ecommerceexam.model.dto.response.ProductResponse;
import com.example.ecommerceexam.model.entity.Product;

public interface ProductMapper {
    Product map(ProductRequest productRequest);

    ProductResponse map(Product product);
}

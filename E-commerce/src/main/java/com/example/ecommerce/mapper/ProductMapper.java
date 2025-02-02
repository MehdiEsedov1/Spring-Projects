package com.example.ecommerce.mapper;

import com.example.ecommerce.model.dto.request.ProductRequest;
import com.example.ecommerce.model.dto.response.ProductResponse;
import com.example.ecommerce.model.entity.Product;

public interface ProductMapper {
    Product map(ProductRequest productRequest);

    ProductResponse map(Product product);
    Product map(Product product,ProductRequest productRequest);
}

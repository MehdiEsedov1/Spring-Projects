package com.example.ecommerce.mapper.impl;

import com.example.ecommerce.mapper.CategoryMapper;
import com.example.ecommerce.mapper.ProductMapper;
import com.example.ecommerce.mapper.SupplierMapper;
import com.example.ecommerce.model.dto.request.ProductRequest;
import com.example.ecommerce.model.dto.response.ProductResponse;
import com.example.ecommerce.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductMapperImpl implements ProductMapper {
    private final SupplierMapper supplierMapper;
    private final CategoryMapper categoryMapper;

    @Override
    public Product map(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
    }

    @Override
    public ProductResponse map(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(categoryMapper.map(product.getCategory()))
                .supplier(supplierMapper.map(product.getSupplier()))
                .build();
    }

    @Override
    public Product map(Product product, ProductRequest productRequest) {
        if (productRequest.getName() != null) {
            product.setName(productRequest.getName());
        }
        if (productRequest.getDescription() != null) {
            product.setDescription(productRequest.getDescription());
        }
        if (productRequest.getPrice() != null) {
            product.setPrice(productRequest.getPrice());
        }
        return product;
    }
}
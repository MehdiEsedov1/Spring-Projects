package com.example.ecommerceexam.mapper.impl;

import com.example.ecommerceexam.mapper.BrandMapper;
import com.example.ecommerceexam.mapper.CategoryMapper;
import com.example.ecommerceexam.mapper.ProductMapper;
import com.example.ecommerceexam.model.dto.request.ProductRequest;
import com.example.ecommerceexam.model.dto.response.ProductResponse;
import com.example.ecommerceexam.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductMapperImpl implements ProductMapper {
    private final CategoryMapper categoryMapper;
    private final BrandMapper brandMapper;

    @Override
    public Product map(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .amount(productRequest.getAmount())
                .productDetails(productRequest.getProductDetails())
                .remainCount(productRequest.getRemainCount())
                .build();
    }

    @Override
    public ProductResponse map(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .amount(product.getAmount())
                .productDetails(product.getProductDetails())
                .remainCount(product.getRemainCount())
                .brandResponse(brandMapper.map(product.getBrand()))
                .categoryResponse(categoryMapper.map(product.getCategory()))
                .build();
    }
}
package com.example.ecommerceexam.mapper.impl;

import com.example.ecommerceexam.mapper.BrandMapper;
import com.example.ecommerceexam.model.dto.request.BrandRequest;
import com.example.ecommerceexam.model.dto.response.BrandResponse;
import com.example.ecommerceexam.model.entity.Brand;
import org.springframework.stereotype.Service;

@Service
public class BrandMapperImpl implements BrandMapper {
    @Override
    public Brand map(BrandRequest brandRequest) {
        return Brand.builder()
                .name(brandRequest.getName())
                .description(brandRequest.getDescription())
                .build();
    }

    @Override
    public BrandResponse map(Brand brand) {
        return BrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .description(brand.getDescription())
                .build();
    }
}

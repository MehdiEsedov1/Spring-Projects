package com.example.ecommerceexam.mapper;

import com.example.ecommerceexam.model.dto.request.BrandRequest;
import com.example.ecommerceexam.model.dto.response.BrandResponse;
import com.example.ecommerceexam.model.entity.Brand;

public interface BrandMapper {
    Brand map(BrandRequest brandRequest);

    BrandResponse map(Brand brand);
}

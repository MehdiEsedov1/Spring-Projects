package com.example.ecommerceexam.service;

import com.example.ecommerceexam.model.dto.request.BrandRequest;
import com.example.ecommerceexam.model.dto.response.BrandResponse;

import java.util.List;

public interface BrandService {
    List<BrandResponse> getAllBrands();

    void addNewBrand(BrandRequest brandRequest);

    BrandResponse getBrandById(Long id);

    void updateBrandById(Long id, BrandRequest brandRequest);
}
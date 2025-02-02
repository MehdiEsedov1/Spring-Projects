package com.example.ecommerceexam.service.impl;

import com.example.ecommerceexam.mapper.BrandMapper;
import com.example.ecommerceexam.model.dto.request.BrandRequest;
import com.example.ecommerceexam.model.dto.response.BrandResponse;
import com.example.ecommerceexam.model.entity.Brand;
import com.example.ecommerceexam.repository.BrandRepo;
import com.example.ecommerceexam.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepo brandRepo;
    private final BrandMapper brandMapper;

    @Override
    public List<BrandResponse> getAllBrands() {
        List<Brand> brands = brandRepo.findAll();
        return brands
                .stream()
                .map(brand -> brandMapper.map(brand))
                .collect(Collectors.toList());
    }

    @Override
    public void addNewBrand(BrandRequest brandRequest) {
        brandRepo.save(brandMapper.map(brandRequest));
    }

    @Override
    public BrandResponse getBrandById(Long id) {
        return brandMapper.map(brandRepo.findById(id).orElseThrow());
    }

    @Override
    public void updateBrandById(Long id, BrandRequest brandRequest) {
        Brand newBrand = brandRepo.findById(id).orElseThrow();
        newBrand.setDescription(brandRequest.getDescription());
        newBrand.setName(brandRequest.getName());
        brandRepo.save(newBrand);
    }
}
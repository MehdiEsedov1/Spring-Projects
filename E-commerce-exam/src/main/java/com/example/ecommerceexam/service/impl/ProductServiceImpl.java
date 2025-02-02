package com.example.ecommerceexam.service.impl;

import com.example.ecommerceexam.mapper.ProductMapper;
import com.example.ecommerceexam.model.dto.request.ProductRequest;
import com.example.ecommerceexam.model.dto.response.ProductResponse;
import com.example.ecommerceexam.model.entity.Brand;
import com.example.ecommerceexam.model.entity.Category;
import com.example.ecommerceexam.model.entity.Product;
import com.example.ecommerceexam.model.enums.Exception;
import com.example.ecommerceexam.model.exception.ApplicationException;
import com.example.ecommerceexam.repository.BrandRepo;
import com.example.ecommerceexam.repository.CategoryRepo;
import com.example.ecommerceexam.repository.ProductRepo;
import com.example.ecommerceexam.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final BrandRepo brandRepo;

    @Override
    public List<ProductResponse> getAllProducts(Long categoryId, Long brandId) {
        List<Product> products = productRepo.findAll();
        if (brandId != null) {
            return products
                    .stream()
                    .filter(product -> product.getBrand().getId() == brandId)
                    .map(brand -> productMapper.map(brand))
                    .collect(Collectors.toList());
        } else if (categoryId != null) {
            return products
                    .stream()
                    .filter(product -> product.getCategory().getId() == categoryId)
                    .map(category -> productMapper.map(category))
                    .collect(Collectors.toList());
        } else {
            return products
                    .stream()
                    .map(category -> productMapper.map(category))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public void addNewProduct(ProductRequest productRequest) {
        Product newProduct = productMapper.map(productRequest);
        Category category = categoryRepo.findById(productRequest.getCategoryId()).orElseThrow();
        Brand brand = brandRepo.findById(productRequest.getBrandId()).orElseThrow();
        newProduct.setBrand(brand);
        newProduct.setCategory(category);
        productRepo.save(newProduct);
    }

    @Override
    public ProductResponse getProductById(Long id) {
        return productMapper.map(
                productRepo.findById(id)
                        .orElseThrow(() -> new ApplicationException(Exception.PRODUCT_NOTFOUND)));
    }

    @Override
    public void updateProductById(Long id, ProductRequest productRequest) {
        Product newProduct = productRepo.findById(id).orElseThrow(() -> new ApplicationException(Exception.PRODUCT_NOTFOUND));
        newProduct.setDescription(productRequest.getDescription());
        newProduct.setName(productRequest.getName());
        productRepo.save(newProduct);
    }
}
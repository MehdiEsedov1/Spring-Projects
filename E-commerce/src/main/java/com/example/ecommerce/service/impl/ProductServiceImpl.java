package com.example.ecommerce.service.impl;

import com.example.ecommerce.mapper.ProductMapper;
import com.example.ecommerce.model.dto.request.ProductRequest;
import com.example.ecommerce.model.dto.response.ProductResponse;
import com.example.ecommerce.model.entity.Category;
import com.example.ecommerce.model.entity.Product;
import com.example.ecommerce.model.entity.Supplier;
import com.example.ecommerce.model.enums.Exceptions;
import com.example.ecommerce.model.exceptions.ApplicationException;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.SupplierRepository;
import com.example.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;

    @Override
    public ResponseEntity<Void> create(ProductRequest request) {
        Product product = productMapper.map(request);
        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new ApplicationException(Exceptions.CATEGORY_NOT_FOUND));
        Supplier supplier = supplierRepository.findById(request.getSupplierId()).orElseThrow(() -> new ApplicationException(Exceptions.SUPPLIER_NOT_FOUND));
        product.setCategory(category);
        product.setSupplier(supplier);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<ProductResponse> findAll(Long categoryId) {
        if (categoryId != null) {
            List<Product> products = productRepository.findAll();
            return products
                    .stream()
                    .map(product -> productMapper.map(product))
                    .collect(Collectors.toList());
        } else {
            List<Product> products = productRepository.findAll();
            return products
                    .stream()
                    .filter(product -> product.getCategory().getId() == categoryId)
                    .map(product -> productMapper.map(product))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public ProductResponse findById(Long id) {
        return productMapper.map(productRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(Exceptions.PRODUCT_NOT_FOUND)));
    }

    @Override
    public ResponseEntity<Void> updateProductById(ProductRequest request, Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(Exceptions.PRODUCT_NOT_FOUND));
        Product newProduct = productMapper.map(product, request);
        productRepository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteProductById(Long id) {
        findById(id);
        productRepository.deleteById(id);
        return null;
    }
}
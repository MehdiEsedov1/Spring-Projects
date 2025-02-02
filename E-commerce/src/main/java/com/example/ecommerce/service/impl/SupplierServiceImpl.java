package com.example.ecommerce.service.impl;

import com.example.ecommerce.mapper.SupplierMapper;
import com.example.ecommerce.model.dto.request.SupplierRequest;
import com.example.ecommerce.model.dto.response.SupplierResponse;
import com.example.ecommerce.model.entity.Supplier;
import com.example.ecommerce.repository.SupplierRepository;
import com.example.ecommerce.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    @Override
    public ResponseEntity<Void> create(SupplierRequest supplierRequest) {
        supplierRepository.save(supplierMapper.map(supplierRequest));
        return ResponseEntity.noContent().build();
    }

    @Override
    public List<SupplierResponse> findAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return suppliers
                .stream()
                .map(category -> supplierMapper.map(category))
                .collect(Collectors.toList());
    }
}
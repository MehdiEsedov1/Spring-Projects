package com.example.ecommerce.mapper.impl;

import com.example.ecommerce.mapper.SupplierMapper;
import com.example.ecommerce.model.dto.request.SupplierRequest;
import com.example.ecommerce.model.dto.response.SupplierResponse;
import com.example.ecommerce.model.entity.Supplier;
import org.springframework.stereotype.Service;

@Service
public class SupplierMapperImpl implements SupplierMapper {
    @Override
    public Supplier map(SupplierRequest supplierRequest) {
        return Supplier.builder()
                .name(supplierRequest.getName())
                .address(supplierRequest.getAddress())
                .build();
    }

    @Override
    public SupplierResponse map(Supplier supplier) {
        return SupplierResponse.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .address(supplier.getAddress())
                .build();
    }
}
package com.example.ecommerce.mapper;

import com.example.ecommerce.model.dto.request.SupplierRequest;
import com.example.ecommerce.model.dto.response.SupplierResponse;
import com.example.ecommerce.model.entity.Supplier;

public interface SupplierMapper {
    Supplier map(SupplierRequest supplierRequest);

    SupplierResponse map(Supplier supplier);
}
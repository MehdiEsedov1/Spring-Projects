package com.example.ecommerce.service;

import com.example.ecommerce.model.dto.request.SupplierRequest;
import com.example.ecommerce.model.dto.response.SupplierResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SupplierService {
    List<SupplierResponse> findAll();
    ResponseEntity<Void> create(SupplierRequest request);
}
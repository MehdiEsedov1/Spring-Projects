package com.example.ecommerce.controller;

import com.example.ecommerce.model.dto.request.SupplierRequest;
import com.example.ecommerce.model.dto.response.SupplierResponse;
import com.example.ecommerce.service.SupplierService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Builder
@RestController
@RequiredArgsConstructor
@RequestMapping("/supplier")
@Tag(name = "Supplier", description = "This is controller about suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping(path = "/getCategory")
    public List<SupplierResponse> findAll() {
        return supplierService.findAll();
    }

    @PostMapping(path = "/postCategory")
    public void create(@RequestBody SupplierRequest supplierRequest) {
        supplierService.create(supplierRequest);
    }
}
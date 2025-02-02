package com.example.ecommerce.controller;

import com.example.ecommerce.model.dto.request.ProductRequest;
import com.example.ecommerce.model.dto.response.ProductResponse;
import com.example.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Builder
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/product")
@Tag(name = "Product", description = "This is controller about products")
public class ProductController {
    private final ProductService productService;

    @GetMapping(path = "/getProduct")
    //ApiResponses və ApiResponse annotasiyaları controller üçün dokumentasiyadır
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ProductResponse.class)))
            )
    )
    List<ProductResponse> findAll(@RequestParam(required = false) Long categoryId) {
        return productService.findAll(categoryId);
    }

    @GetMapping(path = "/getProductById/{id}")
    ProductResponse findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping(path = "/postProduct")
    ResponseEntity<Void> create(@RequestBody @Valid ProductRequest productRequest) {
        productService.create(productRequest);
        return null;
    }

    @PutMapping(path = "/putProduct/{id}")
    ResponseEntity<Void> updateProductById(@RequestBody ProductRequest request, @PathVariable Long id) {
        productService.updateProductById(request, id);
        return null;
    }

    @DeleteMapping(path = "/deleteProduct/{id}")
    ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return null;
    }
}
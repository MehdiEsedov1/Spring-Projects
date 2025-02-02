package com.example.ecommerceexam.controller;

import com.example.ecommerceexam.model.dto.request.BrandRequest;
import com.example.ecommerceexam.model.dto.response.BrandResponse;
import com.example.ecommerceexam.model.dto.response.CategoryResponse;
import com.example.ecommerceexam.service.BrandService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "brand")
public class BrandController {
    private final BrandService brandService;

    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = BrandResponse.class)))
            )
    )
    @GetMapping(path = "/getAllBrands")
    List<BrandResponse> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping(path = "/getBrandById/{id}")
    BrandResponse getBrand(@PathVariable Long id) {
        return brandService.getBrandById(id);
    }

    @PostMapping(path = "/postBrand")
    void postBrand(@RequestBody @Valid BrandRequest brandRequest) {
        brandService.addNewBrand(brandRequest);
    }

    @PutMapping(path = "putBrandById/{id}")
    void putBrandById(@RequestBody @Valid BrandRequest brandRequest, @PathVariable Long id) {
        brandService.updateBrandById(id, brandRequest);
    }
}
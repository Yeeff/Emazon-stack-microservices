package com.demo.emazon_stack_microservices.adapters.driving.http.controller;


import com.demo.emazon_stack_microservices.adapters.driving.http.dto.request.AddBrandRequest;
import com.demo.emazon_stack_microservices.adapters.driving.http.dto.response.BrandResponse;
import com.demo.emazon_stack_microservices.adapters.driving.http.mapper.IBrandRequestMapper;
import com.demo.emazon_stack_microservices.adapters.driving.http.mapper.IBrandResponseMapper;
import com.demo.emazon_stack_microservices.domain.api.IBrandServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandRestControllerAdapter {
    private final IBrandServicePort brandServicePort;
    private final IBrandRequestMapper brandRequestMapper;
    private final IBrandResponseMapper brandResponseMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addBrand(@Valid @RequestBody AddBrandRequest brand) {
        brandServicePort.addBrand(brandRequestMapper.addRequestToBrand(brand));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<BrandResponse>> getBrands(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortDirection
    ) {
        return ResponseEntity.ok(brandResponseMapper.toBrandResponseList(
                brandServicePort.getAllBrands(size,page,sortDirection)
        ));
    }
}

package com.demo.emazon_stack_microservices.adapters.driving.http.controller;


import com.demo.emazon_stack_microservices.adapters.driving.http.dto.request.AddCategoryRequest;
import com.demo.emazon_stack_microservices.adapters.driving.http.dto.response.CategoryResponse;
import com.demo.emazon_stack_microservices.adapters.driving.http.mapper.ICategoryRequestMapper;
import com.demo.emazon_stack_microservices.adapters.driving.http.mapper.ICategoryResponseMapper;
import com.demo.emazon_stack_microservices.domain.api.ICategoryServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryRestControllerAdapter {
    private final ICategoryServicePort categoryServicePort;
    private final ICategoryRequestMapper categoryRequestMapper;
    private final ICategoryResponseMapper categoryResponseMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addCategory(@Valid @RequestBody AddCategoryRequest request) {
        categoryServicePort.addCategory(categoryRequestMapper.addRequestToCategory(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryResponse>> getCategories() {
        return ResponseEntity.ok(categoryResponseMapper.toCategoryResponseList(categoryServicePort.getAllCategories()));
    }
}

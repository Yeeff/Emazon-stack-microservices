package com.demo.emazon_stack_microservices.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CategoryResponse {
    private final Long id;
    private final String  name;
    private final String description;
}

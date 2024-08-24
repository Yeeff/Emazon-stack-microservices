package com.demo.emazon_stack_microservices.adapters.driving.http.mapper;

import com.demo.emazon_stack_microservices.adapters.driving.http.dto.request.AddCategoryRequest;
import com.pragma.arquetipobootcamp2024.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICategoryRequestMapper {
    @Mapping(target = "id", ignore = true)
    Category addRequestToCategory(AddCategoryRequest addCategoryRequest);
}

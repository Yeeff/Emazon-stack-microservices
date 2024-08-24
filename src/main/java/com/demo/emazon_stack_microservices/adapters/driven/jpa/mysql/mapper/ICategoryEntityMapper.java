package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.mapper;

import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.pragma.arquetipobootcamp2024.domain.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoryEntityMapper {
    Category toModel(CategoryEntity categoryEntity);
    CategoryEntity toEntity(Category category);
    List<Category> toModelList(List<CategoryEntity> categoriesEntities);
}

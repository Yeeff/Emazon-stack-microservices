package com.demo.emazon_stack_microservices.domain.api;

import com.pragma.arquetipobootcamp2024.domain.model.Category;

import java.util.List;

public interface ICategoryServicePort {
    void addCategory(Category category);
    List<Category> getAllCategories();
}

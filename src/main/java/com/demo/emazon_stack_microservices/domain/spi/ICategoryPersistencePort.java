package com.demo.emazon_stack_microservices.domain.spi;

import com.pragma.arquetipobootcamp2024.domain.model.Category;

import java.util.List;

public interface ICategoryPersistencePort {
    void addSupplier(Category category);
    List<Category> getAllCategories();
}

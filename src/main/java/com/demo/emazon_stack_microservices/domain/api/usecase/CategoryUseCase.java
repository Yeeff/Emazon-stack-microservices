package com.demo.emazon_stack_microservices.domain.api.usecase;

import com.demo.emazon_stack_microservices.domain.api.ICategoryServicePort;
import com.demo.emazon_stack_microservices.domain.spi.ICategoryPersistencePort;
import com.pragma.arquetipobootcamp2024.domain.model.Category;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {
    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void addCategory(Category category) {
        categoryPersistencePort.addSupplier(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryPersistencePort.getAllCategories();
    }
}

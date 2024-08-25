package com.demo.emazon_stack_microservices.domain.spi;


import com.demo.emazon_stack_microservices.domain.model.Category;

import java.util.List;

public interface ICategoryPersistencePort {
    void addCategory(Category category);
    List<Category> getAllCategories();
    Boolean existsByName(String name);
}

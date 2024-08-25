package com.demo.emazon_stack_microservices.domain.spi;


import com.demo.emazon_stack_microservices.domain.model.Category;

import java.util.List;

public interface ICategoryPersistencePort {
    void addCategory(Category category);
    List<Category> getAllCategories(Integer size, Integer page, String sortDirection);
    Boolean existsByName(String name);
}

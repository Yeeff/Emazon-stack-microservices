package com.demo.emazon_stack_microservices.domain.api;


import com.demo.emazon_stack_microservices.domain.model.Category;

import java.util.List;

public interface ICategoryServicePort {
    void addCategory(Category category);
    List<Category> getAllCategories(Integer size, Integer page, String sortDirection);
}

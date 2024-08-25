package com.demo.emazon_stack_microservices.domain.api.usecase;

import com.demo.emazon_stack_microservices.domain.api.ICategoryServicePort;
import com.demo.emazon_stack_microservices.domain.exception.CategoryNonUniqueNameException;
import com.demo.emazon_stack_microservices.domain.model.Category;
import com.demo.emazon_stack_microservices.domain.spi.ICategoryPersistencePort;
import com.demo.emazon_stack_microservices.domain.util.DomainConstants;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {
    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void addCategory(Category category) {

        Boolean exists = categoryPersistencePort.existsByName(category.getName());

        if (Boolean.TRUE.equals(exists)) {
            throw new CategoryNonUniqueNameException(DomainConstants.CATEGORY_NAME_MUST_BE_UNIQUE);
        } else {
            categoryPersistencePort.addCategory(category);
        }
    }

    @Override
    public List<Category> getAllCategories(Integer size, Integer page, String sortDirection) {

        return categoryPersistencePort.getAllCategories(size, page, sortDirection);
    }
}

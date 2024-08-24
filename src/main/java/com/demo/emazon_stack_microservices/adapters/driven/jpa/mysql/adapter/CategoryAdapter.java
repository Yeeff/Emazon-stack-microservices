package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.adapter;


import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.CategoryAlreadyExistsException;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.repository.ICategoryRepository;
import com.demo.emazon_stack_microservices.domain.spi.ICategoryPersistencePort;
import com.pragma.arquetipobootcamp2024.domain.model.Category;
import lombok.RequiredArgsConstructor;


import java.util.List;

@RequiredArgsConstructor
public class CategoryAdapter implements ICategoryPersistencePort {
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    @Override
    public void addSupplier(Category category) {
        if (categoryRepository.findByName(category.getName()).isPresent()) {
            throw new CategoryAlreadyExistsException();
        }
        categoryRepository.save(categoryEntityMapper.toEntity(category));
    }

    @Override
    public List<Category> getAllCategories() {

        List<CategoryEntity> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new NoDataFoundException();
        }
        return categoryEntityMapper.toModelList(categories);
    }
}

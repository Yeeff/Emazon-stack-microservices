package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.adapter;


import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.CategoryAlreadyExistsException;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.repository.ICategoryRepository;
import com.demo.emazon_stack_microservices.domain.model.Category;
import com.demo.emazon_stack_microservices.domain.spi.ICategoryPersistencePort;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.utils.PageableUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;


import java.util.List;

@RequiredArgsConstructor
public class CategoryAdapter implements ICategoryPersistencePort {
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    @Override
    public void addCategory(Category category) {
        if (categoryRepository.findByName(category.getName()).isPresent()) {
            throw new CategoryAlreadyExistsException();
        }
        categoryRepository.save(categoryEntityMapper.toEntity(category));
    }

    @Override
    public List<Category> getAllCategories(Integer size, Integer page, String sortDirection) {

        PageableUtils.validatePageableParameters(size,page,sortDirection);
        Pageable pageable = PageableUtils.getPageable(size,page,sortDirection);

        List<CategoryEntity> categories = categoryRepository.findAll(pageable).getContent();
        if (categories.isEmpty()) {
            throw new NoDataFoundException();
        }

        return categoryEntityMapper.toModelList(categories);
    }

    @Override
    public Boolean existsByName(String name) {
        return categoryRepository.existsByName(name);
    }
}

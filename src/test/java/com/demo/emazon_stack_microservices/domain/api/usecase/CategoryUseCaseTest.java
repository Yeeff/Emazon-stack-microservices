package com.demo.emazon_stack_microservices.domain.api.usecase;

import com.demo.emazon_stack_microservices.domain.exception.CategoryNonUniqueNameException;
import com.demo.emazon_stack_microservices.domain.model.Category;
import com.demo.emazon_stack_microservices.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


class CategoryUseCaseTest {
    @Mock
    private ICategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddCategory_whenCategoryNameExists_throwsException() {

        Category category = new Category(1L, "Electronics", "All electronic items");
        when(categoryPersistencePort.existsByName(anyString())).thenReturn(true);

        assertThrows(CategoryNonUniqueNameException.class, () -> categoryUseCase.addCategory(category));

        verify(categoryPersistencePort, never()).addCategory(any(Category.class));
    }

    @Test
    void testAddCategory_whenCategoryNameDoesNotExist_addsCategory() {
        Category category = new Category(1L, "Electronics", "All electronic items");
        when(categoryPersistencePort.existsByName(anyString())).thenReturn(false);

        categoryUseCase.addCategory(category);

        verify(categoryPersistencePort, times(1)).addCategory(category);
    }

    @Test
    void testGetAllCategories_returnsCategoryList() {
        List<Category> categories = Collections.singletonList(
                new Category(1L, "Electronics", "All electronic items")
        );

        when(categoryPersistencePort.getAllCategories(10,1,"Asc")).thenReturn(categories);

        List<Category> result = categoryUseCase.getAllCategories(10,1,"Asc");

        assertEquals(1, result.size());
        assertEquals("Electronics", result.get(0).getName());
        verify(categoryPersistencePort, times(1)).getAllCategories(10,1,"Asc");
    }

    @Test
    void testGetAllCategoriesWithValidPaginationParameters() {

        Integer size = 5;
        Integer page = 0;
        String sortDirection = "ASC";

        List<Category> expectedCategories = List.of(
                new Category(1L, "Category1", "Description1"),
                new Category(2L, "Category2", "Description2")
        );

        when(categoryPersistencePort.getAllCategories(size, page, sortDirection)).thenReturn(expectedCategories);

        categoryUseCase.getAllCategories(size, page, sortDirection);

        verify(categoryPersistencePort, times(1)).getAllCategories(size, page, sortDirection);
    }

}
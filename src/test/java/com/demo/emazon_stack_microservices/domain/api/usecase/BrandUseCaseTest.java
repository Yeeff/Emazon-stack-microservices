package com.demo.emazon_stack_microservices.domain.api.usecase;

import com.demo.emazon_stack_microservices.domain.exception.BrandNonUniqueNameException;
import com.demo.emazon_stack_microservices.domain.model.Brand;
import com.demo.emazon_stack_microservices.domain.spi.IBrandPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class BrandUseCaseTest {
    @Mock
    private IBrandPersistencePort brandPersistencePort;

    @InjectMocks
    private BrandUseCase brandUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddCategory_whenCategoryNameExists_throwsException() {

        Brand brand = new Brand(1L, "LG", "All electronic Brands");
        when(brandPersistencePort.existsByName(anyString())).thenReturn(true);

        assertThrows(BrandNonUniqueNameException.class, () -> brandUseCase.addBrand(brand));

        verify(brandPersistencePort, never()).addBrand(any(Brand.class));
    }

    @Test
    void testAddCategory_whenCategoryNameDoesNotExist_addsCategory() {
        Brand brand = new Brand(1L, "LG", "All electronic Brands");
        when(brandPersistencePort.existsByName(anyString())).thenReturn(false);

        brandUseCase.addBrand(brand);

        verify(brandPersistencePort, times(1)).addBrand(brand);
    }

    @Test
    void testGetAllCategories_returnsCategoryList() {
        List<Brand> brands = Collections.singletonList(
                new Brand(1L, "LG", "All electronic brands")
        );

        when(brandPersistencePort.getAllBrands(anyInt(),anyInt(),anyString())).thenReturn(brands);

        List<Brand> result = brandUseCase.getAllBrands(1,0,"ASC");

        assertEquals(1, result.size());
        assertEquals("LG", result.get(0).getName());
        verify(brandPersistencePort, times(1)).getAllBrands(1,0,"ASC");
    }

    @Test
    void testGetAllCategoriesWithValidPaginationParameters() {

        Integer size = 5;
        Integer page = 0;
        String sortDirection = "ASC";

        List<Brand> expectedBrands = List.of(
                new Brand(1L, "Category1", "Description1"),
                new Brand(2L, "Category2", "Description2")
        );

        when(brandPersistencePort.getAllBrands(size, page, sortDirection)).thenReturn(expectedBrands);

        List<Brand> actualBrands = brandUseCase.getAllBrands(size, page, sortDirection);

        assertNotNull(actualBrands, "The returned brand list should not be null.");
        assertEquals(expectedBrands.size(), actualBrands.size(), "The size of the returned brand list should match the expected size.");
        assertEquals(expectedBrands, actualBrands, "The returned brand list should match the expected brands.");

        verify(brandPersistencePort, times(1)).getAllBrands(size, page, sortDirection);
    }

}
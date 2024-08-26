package com.demo.emazon_stack_microservices.domain.spi;


import com.demo.emazon_stack_microservices.domain.model.Brand;

import java.util.List;

public interface IBrandPersistencePort {
    void addBrand(Brand brand);
    List<Brand> getAllBrands(Integer size, Integer page, String sortDirection);
    Boolean existsByName(String name);
}

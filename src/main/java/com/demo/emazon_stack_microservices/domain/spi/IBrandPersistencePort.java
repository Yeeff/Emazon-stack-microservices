package com.demo.emazon_stack_microservices.domain.spi;


import com.demo.emazon_stack_microservices.domain.model.Brand;

import java.util.List;

public interface IBrandPersistencePort {
    void addBrand(Brand brand);
    List<Brand> getAllBrands();
    Boolean existsByName(String name);
}

package com.demo.emazon_stack_microservices.domain.api;


import com.demo.emazon_stack_microservices.domain.model.Brand;

import java.util.List;

public interface IBrandServicePort {
    void addBrand(Brand brand);
    List<Brand> getAllBrands();
}

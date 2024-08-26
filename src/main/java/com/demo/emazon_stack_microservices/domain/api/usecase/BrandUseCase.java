package com.demo.emazon_stack_microservices.domain.api.usecase;

import com.demo.emazon_stack_microservices.domain.api.IBrandServicePort;
import com.demo.emazon_stack_microservices.domain.exception.BrandNonUniqueNameException;
import com.demo.emazon_stack_microservices.domain.model.Brand;
import com.demo.emazon_stack_microservices.domain.spi.IBrandPersistencePort;
import com.demo.emazon_stack_microservices.domain.util.DomainConstants;

import java.util.List;

public class BrandUseCase implements IBrandServicePort {
    private final IBrandPersistencePort brandPersistencePort;

    public BrandUseCase(IBrandPersistencePort brandPersistencePort) {
        this.brandPersistencePort = brandPersistencePort;
    }

    @Override
    public void addBrand(Brand brand) {

        Boolean exists = brandPersistencePort.existsByName(brand.getName());

        if (Boolean.TRUE.equals(exists)) {
            throw new BrandNonUniqueNameException(DomainConstants.BRAND_NAME_MUST_BE_UNIQUE);
        } else {
            brandPersistencePort.addBrand(brand);
        }
    }

    @Override
    public List<Brand> getAllBrands(Integer size, Integer page, String sortDirection) {

        return brandPersistencePort.getAllBrands(size,page,sortDirection);
    }
}

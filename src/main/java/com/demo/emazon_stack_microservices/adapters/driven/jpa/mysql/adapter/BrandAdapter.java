package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.adapter;

import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.entity.BrandEntity;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.BrandAlreadyExistsException;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.mapper.IBrandEntityMapper;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.repository.IBrandRepository;
import com.demo.emazon_stack_microservices.domain.model.Brand;
import com.demo.emazon_stack_microservices.domain.spi.IBrandPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BrandAdapter implements IBrandPersistencePort {

    private final IBrandRepository brandRepository;
    private final IBrandEntityMapper brandEntityMapper;

    @Override
    public void addBrand(Brand brand) {
        if (brandRepository.findByName(brand.getName()).isPresent()) {
            throw new BrandAlreadyExistsException();
        }
        brandRepository.save(brandEntityMapper.toEntity(brand));
    }

    @Override
    public List<Brand> getAllBrands() {

        List<BrandEntity> brands = brandRepository.findAll();
        if (brands.isEmpty()) {
            throw new NoDataFoundException();
        }
        return brandEntityMapper.toModelList(brands);
    }

    @Override
    public Boolean existsByName(String name) {
        return brandRepository.existsByName(name);
    }
}

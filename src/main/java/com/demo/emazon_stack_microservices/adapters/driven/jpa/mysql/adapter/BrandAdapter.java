package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.adapter;

import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.entity.BrandEntity;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.BrandAlreadyExistsException;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.mapper.IBrandEntityMapper;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.repository.IBrandRepository;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.utils.PageableUtils;
import com.demo.emazon_stack_microservices.domain.model.Brand;
import com.demo.emazon_stack_microservices.domain.spi.IBrandPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

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
    public List<Brand> getAllBrands(Integer size, Integer page, String sortDirection) {

        PageableUtils.validatePageableParameters(size,page,sortDirection);

        Pageable pageable = PageableUtils.getPageable(size,page,sortDirection);

        List<BrandEntity> brands = brandRepository.findAll(pageable).getContent();
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

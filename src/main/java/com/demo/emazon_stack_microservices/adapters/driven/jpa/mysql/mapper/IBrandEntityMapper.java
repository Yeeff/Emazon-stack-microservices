package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.mapper;

import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.entity.BrandEntity;
import com.demo.emazon_stack_microservices.domain.model.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBrandEntityMapper {
    Brand toModel(BrandEntity brandEntity);
    BrandEntity toEntity(Brand brand);
    List<Brand> toModelList(List<BrandEntity> categoriesEntities);
}

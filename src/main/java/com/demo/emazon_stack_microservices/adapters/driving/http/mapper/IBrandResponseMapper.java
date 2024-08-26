package com.demo.emazon_stack_microservices.adapters.driving.http.mapper;

import com.demo.emazon_stack_microservices.adapters.driving.http.dto.response.BrandResponse;
import com.demo.emazon_stack_microservices.domain.model.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBrandResponseMapper {
    BrandResponse toBrandResponse(Brand brand);
    List<BrandResponse> toBrandResponseList(List<Brand> brands);
}

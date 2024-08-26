package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.repository;

import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IBrandRepository extends JpaRepository<BrandEntity, Long> {
    Optional<BrandEntity> findByName(String name);
    List<BrandEntity> findAll();
    Boolean existsByName( String name);

}

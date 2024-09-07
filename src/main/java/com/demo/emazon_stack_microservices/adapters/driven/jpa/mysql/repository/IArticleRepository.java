package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.repository;

import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.entity.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IArticleRepository extends JpaRepository<ArticleEntity, Long> {

    Page<ArticleEntity> findAll(Pageable pageable);
    Optional<ArticleEntity> findByName(String name);
    Boolean existsByName(String name);


}

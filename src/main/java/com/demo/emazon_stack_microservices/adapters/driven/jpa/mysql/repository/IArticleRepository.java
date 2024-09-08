package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.repository;

import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.entity.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IArticleRepository extends JpaRepository<ArticleEntity, Long> {

    Page<ArticleEntity> findAll(Pageable pageable);
    Optional<ArticleEntity> findByName(String name);
    Boolean existsByName(String name);
    Optional<ArticleEntity> findByNameContaining(String name);

    Page<ArticleEntity> findAllByBrandNameContaining(String brandName, Pageable pageable);
    @Query(value = "SELECT a.* FROM article a " +
            "JOIN article_category ac ON a.id = ac.article_id " +
            "JOIN category c ON ac.category_id = c.id " +
            "WHERE c.name = :categoryName", nativeQuery = true)
    List<ArticleEntity> findAllByCategoryName(@Param("categoryName") String categoryName,Pageable pageable);


}

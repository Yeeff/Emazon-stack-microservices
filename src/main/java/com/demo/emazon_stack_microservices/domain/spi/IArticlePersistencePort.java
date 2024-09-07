package com.demo.emazon_stack_microservices.domain.spi;


import com.demo.emazon_stack_microservices.domain.model.Article;

public interface IArticlePersistencePort {
    void addArticle(Article article);
    Boolean existsByName(String name);
}

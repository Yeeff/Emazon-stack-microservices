package com.demo.emazon_stack_microservices.domain.spi;


import com.demo.emazon_stack_microservices.domain.model.Article;

import java.util.List;

public interface IArticlePersistencePort {
    void addArticle(Article article);

    Boolean existsByName(String name);

    List<Article> getAllArticles(int page, int size, String sortDirection);

    Article getArticle(String articleName);

    List<Article> getAllArticlesByCategory(Integer page, Integer size, String sortDirection, String categoryName);

    List<Article> getAllArticlesByBrand(Integer page, Integer size, String sortDirection, String brandName);

}

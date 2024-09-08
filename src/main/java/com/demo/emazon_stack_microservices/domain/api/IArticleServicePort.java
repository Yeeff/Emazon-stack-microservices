package com.demo.emazon_stack_microservices.domain.api;


import com.demo.emazon_stack_microservices.domain.model.Article;

import java.util.List;


public interface IArticleServicePort {
    void addArticle(Article article);

    List<Article> getAllArticles(int page, int size, String sortDirection);

    Article getArticle(String articleName);

    List<Article> getAllArticlesByCategory(Integer page, Integer size, String sortDirection, String categoryName);

    List<Article> getAllArticlesByBrand(Integer page, Integer size, String sortDirection, String brandName);
}

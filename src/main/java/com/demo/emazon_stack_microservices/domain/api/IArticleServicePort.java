package com.demo.emazon_stack_microservices.domain.api;


import com.demo.emazon_stack_microservices.domain.model.Article;


public interface IArticleServicePort {
    void addArticle(Article article);
}

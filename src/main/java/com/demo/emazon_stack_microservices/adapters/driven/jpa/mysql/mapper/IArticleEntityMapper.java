package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.mapper;

import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.entity.ArticleEntity;
import com.demo.emazon_stack_microservices.domain.model.Article;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IArticleEntityMapper {

    Article toModel(ArticleEntity articleEntity);
    ArticleEntity toEntity(Article article);
    List<Article> toModelList(List<ArticleEntity> articleEntities);
}

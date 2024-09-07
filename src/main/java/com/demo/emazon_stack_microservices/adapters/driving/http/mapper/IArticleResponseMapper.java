package com.demo.emazon_stack_microservices.adapters.driving.http.mapper;

import com.demo.emazon_stack_microservices.adapters.driving.http.dto.response.ArticleResponse;
import com.demo.emazon_stack_microservices.domain.model.Article;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IArticleResponseMapper {
    ArticleResponse toArticledResponse(Article article);
}

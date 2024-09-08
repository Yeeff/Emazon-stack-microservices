package com.demo.emazon_stack_microservices.adapters.driving.http.mapper;

import com.demo.emazon_stack_microservices.adapters.driving.http.dto.response.ArticleResponse;
import com.demo.emazon_stack_microservices.adapters.driving.http.dto.response.CategoryResponse;
import com.demo.emazon_stack_microservices.domain.model.Article;
import com.demo.emazon_stack_microservices.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IArticleResponseMapper {
    @Mapping(target = "categories", source = "categories", qualifiedByName = "mapCategories")
    ArticleResponse toArticledResponse(Article article);

    List<ArticleResponse> toArticledResponseList(List<Article> articleList);

    @Named("mapCategories")
    default List<CategoryResponse> mapCategories(List<Category> categories) {
        return categories.stream()
                .map(category -> new CategoryResponse(category.getId(), category.getName()))
                .toList();
    }
}

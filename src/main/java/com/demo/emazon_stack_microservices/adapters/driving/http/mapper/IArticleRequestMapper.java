package com.demo.emazon_stack_microservices.adapters.driving.http.mapper;

import com.demo.emazon_stack_microservices.adapters.driving.http.dto.request.AddArticleRequest;
import com.demo.emazon_stack_microservices.domain.model.Article;
import com.demo.emazon_stack_microservices.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IArticleRequestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "categories", target = "categories", qualifiedByName = "mapCategoryIds")
    Article addRequestToArticle(AddArticleRequest addArticleRequest);

    @Named(value = "mapCategoryIds")
        default List<Category> mapCategoryIds(List<Long> categories) {
        if (categories == null) {
            return Collections.emptyList();
        }
        return categories.stream()
                .map(id -> new Category(id,"name","description"))
                .toList();
    }

}

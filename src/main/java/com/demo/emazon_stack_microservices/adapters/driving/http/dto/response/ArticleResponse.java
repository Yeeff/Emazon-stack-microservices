package com.demo.emazon_stack_microservices.adapters.driving.http.dto.response;

import com.demo.emazon_stack_microservices.domain.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
public class ArticleResponse {
    private final Long id;
    private final String  name;
    private final String description;
    private final BigDecimal price;
    private final Long quantity;
    private List<Category> categories;
}

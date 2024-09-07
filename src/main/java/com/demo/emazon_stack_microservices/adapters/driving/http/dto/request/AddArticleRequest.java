package com.demo.emazon_stack_microservices.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;


@AllArgsConstructor
@Getter
public class AddArticleRequest {

    private final String  name;
    private final String description;
    private final BigDecimal price;
    private final Long quantity;
    private List<Long> categories;
}

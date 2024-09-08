package com.demo.emazon_stack_microservices.domain.model;

import com.demo.emazon_stack_microservices.domain.exception.EmptyFieldException;
import com.demo.emazon_stack_microservices.domain.exception.MaxCategoriesExceededException;
import com.demo.emazon_stack_microservices.domain.exception.MinCategoriesNotMetException;
import com.demo.emazon_stack_microservices.domain.exception.NegativeNotAllowedException;
import com.demo.emazon_stack_microservices.domain.util.DomainConstants;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class Article {
    private final Long id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final Long quantity;

    private Brand brand;
    private List<Category> categories;

    public Article(long id, String name, String description, BigDecimal price, Long quantity, List<Category> categories, Brand brand) {
        if (name.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }
        if (description.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.DESCRIPTION.toString());
        }
        if (price == null) {
            throw new EmptyFieldException(DomainConstants.Field.PRICE.toString());
        }
        if (quantity == null) {
            throw new EmptyFieldException(DomainConstants.Field.QUANTITY.toString());
        }
        if (categories == null) {
            throw new EmptyFieldException(DomainConstants.Field.CATEGORIES.toString());
        }
        if (brand == null) {
            throw new EmptyFieldException(DomainConstants.Field.BRAND.toString());
        }

        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new NegativeNotAllowedException(DomainConstants.Field.PRICE.toString());
        }
        if (quantity < 0) {
            throw new NegativeNotAllowedException(DomainConstants.Field.QUANTITY.toString());
        }

        if (categories.size() < DomainConstants.MIN_CATEGORIES_BY_ARTICLE) {
            throw new MinCategoriesNotMetException(DomainConstants.MIM_CATEGORIES_NOT_MET_MESSAGE);
        }
        if (categories.size() > DomainConstants.MAX_CATEGORIES_BY_ARTICLE) {
            throw new MaxCategoriesExceededException(DomainConstants.MAX_CATEGORIES_EXCEEDED_MESSAGE);
        }

        this.id = id;
        this.name = requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.description = requireNonNull(description, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        this.price = requireNonNull(price, DomainConstants.FIELD_PRICE_NULL_MESSAGE);
        this.quantity = requireNonNull(quantity, DomainConstants.FIELD_QUANTITY_NULL_MESSAGE);
        this.categories = requireNonNull(categories, DomainConstants.FIELD_CATEGORIES_NULL_MESSAGE);
        this.brand = requireNonNull(brand, DomainConstants.FIELD_BRAND_NULL_MESSAGE);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public List<Category> getCategories() {
        return categories;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}

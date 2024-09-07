package com.demo.emazon_stack_microservices.domain.util;

public final class DomainConstants {
    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    public enum Field {
        NAME,
        DESCRIPTION,
        PRICE,
        QUANTITY,
        CATEGORIES
    }

    public static final int MAX_CATEGORY_NAME_LENGTH = 50;
    public static final int MAX_CATEGORY_DESCRIPTION_LENGTH = 90;
    public static final int MAX_BRAND_NAME_LENGTH = 50;
    public static final int MAX_BRAND_DESCRIPTION_LENGTH = 120;
    public static final int MAX_CATEGORIES_BY_ARTICLE = 3;
    public static final int MIN_CATEGORIES_BY_ARTICLE = 1;

    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' cannot be null";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' cannot be null";
    public static final String CATEGORY_NAME_MUST_BE_UNIQUE_MESSAGE = "Category name must be unique";
    public static final String DUPLICATED_CATEGORIES_MESSAGE = "Article cannot have duplicate categories";
    public static final String BRAND_NAME_MUST_BE_UNIQUE_MESSAGE = "Brand name must be unique";
    public static final String FIELD_QUANTITY_NULL_MESSAGE = "Field 'quantity' cannot be null";
    public static final String FIELD_PRICE_NULL_MESSAGE = "Field 'price' cannot be null";
    public static final String FIELD_CATEGORIES_NULL_MESSAGE = "Field 'categories' cannot be null";
    public static final String MIM_CATEGORIES_NOT_MET_MESSAGE = "Article must have at least "+ MIN_CATEGORIES_BY_ARTICLE +" category";
    public static final String MAX_CATEGORIES_EXCEEDED_MESSAGE = "Article cannot have more than "+MAX_CATEGORIES_BY_ARTICLE+" categories";
}

package com.demo.emazon_stack_microservices.domain.util;

public final class DomainConstants {
    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    public enum Field {
        NAME,
        DESCRIPTION
    }

    public static final int MAX_CATEGORY_NAME_LENGTH = 50;
    public static final int MAX_CATEGORY_DESCRIPTION_LENGTH = 90;
    public static final int MAX_BRAND_NAME_LENGTH = 50;
    public static final int MAX_BRAND_DESCRIPTION_LENGTH = 120;

    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' cannot be null";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' cannot be null";
    public static final String CATEGORY_NAME_MUST_BE_UNIQUE = "Category name must be unique";
    public static final String BRAND_NAME_MUST_BE_UNIQUE = "Brand name must be unique";
}

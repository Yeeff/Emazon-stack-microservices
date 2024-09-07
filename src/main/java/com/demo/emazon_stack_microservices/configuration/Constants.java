package com.demo.emazon_stack_microservices.configuration;

public class Constants {
    private Constants(){
        throw new IllegalStateException("utility class");
    }

    public static final String NO_DATA_FOUND_EXCEPTION_MESSAGE = "No data was found in the database";
    public static final String ELEMENT_NOT_FOUND_EXCEPTION_MESSAGE = "The element indicated does not exist";
    public static final String CATEGORY_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The category you want to create already exists";
    public static final String BRAND_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The brand you want to create already exists";
    public static final String ARTICLE_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The Article you want to create already exists";
    public static final String EMPTY_FIELD_EXCEPTION_MESSAGE = "Field %s can not be empty";
    public static final String CHARACTERS_LONGER_THAN_EXPECTED_EXCEPTION_MESSAGE = "Field %s can not be longer than %s";
    public static final String INVALID_SORT_DIRECTION_EXCEPTION_MESSAGE = "Sort direction must be one of this -> %s ";
    public static final String INVALID_SIZE_EXCEPTION_MESSAGE = "Page size cannot be less than %s";
    public static final String INVALID_PAGE_EXCEPTION_MESSAGE = "Page number cannot be less than %s";
    public static final String NULL_PAGINATION_PARAMETER_EXCEPTION_MESSAGE = "Parameter %s cannot be null.";
    public static final String CATEGORY_NOT_FOUND_EXCEPTION_MESSAGE = "Categories not found for IDs: %s";
    public static final String NEGATIVE_NOT_ALLOWED_EXCEPTION_MESSAGE = "Field %s can not receive negative values";



}

package com.demo.emazon_stack_microservices.configuration;

public class Constants {
    private Constants(){
        throw new IllegalStateException("utility class");
    }

    public static final String NO_DATA_FOUND_EXCEPTION_MESSAGE = "No data was found in the database";
    public static final String ELEMENT_NOT_FOUND_EXCEPTION_MESSAGE = "The element indicated does not exist";
    public static final String CATEGORY_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The category you want to create already exists";
    public static final String EMPTY_FIELD_EXCEPTION_MESSAGE = "Field %s can not be empty";
    public static final String CHARACTERS_LONGER_THAN_EXPECTED_EXCEPTION_MESSAGE = "Field %s can not be longer than %s";
}

package com.demo.emazon_stack_microservices.domain.exception;

public class CategoryNonUniqueNameException extends RuntimeException {
    public CategoryNonUniqueNameException(String message) {
        super(message);
    }
}

package com.demo.emazon_stack_microservices.domain.exception;

public class MaxCategoriesExceededException extends RuntimeException {
    public MaxCategoriesExceededException(String message) {
        super(message);
    }
}

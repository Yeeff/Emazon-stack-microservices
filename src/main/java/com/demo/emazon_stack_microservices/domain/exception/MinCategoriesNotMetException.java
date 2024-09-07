package com.demo.emazon_stack_microservices.domain.exception;

public class MinCategoriesNotMetException extends RuntimeException {
    public MinCategoriesNotMetException(String message) {
        super(message);
    }
}

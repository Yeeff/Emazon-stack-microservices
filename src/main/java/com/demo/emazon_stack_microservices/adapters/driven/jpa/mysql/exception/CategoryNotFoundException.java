package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}

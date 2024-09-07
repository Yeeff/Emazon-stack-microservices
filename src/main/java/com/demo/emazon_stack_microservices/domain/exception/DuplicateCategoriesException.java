package com.demo.emazon_stack_microservices.domain.exception;

public class DuplicateCategoriesException extends RuntimeException {
    public DuplicateCategoriesException(String message) {
        super(message);
    }
}

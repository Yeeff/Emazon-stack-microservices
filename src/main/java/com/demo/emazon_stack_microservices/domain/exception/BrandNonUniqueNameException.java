package com.demo.emazon_stack_microservices.domain.exception;

public class BrandNonUniqueNameException extends RuntimeException {
    public BrandNonUniqueNameException(String message) {
        super(message);
    }
}

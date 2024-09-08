package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception;

public class BrandNotFoundException extends RuntimeException {
    public BrandNotFoundException(String message) {
        super(message);
    }
}

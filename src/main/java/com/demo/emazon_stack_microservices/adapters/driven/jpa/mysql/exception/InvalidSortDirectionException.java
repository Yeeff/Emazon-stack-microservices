package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception;

public class InvalidSortDirectionException extends RuntimeException {
    public InvalidSortDirectionException(String message) {
        super(message);
    }
}
package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception;

public class PageNumberOutOfRangeException extends RuntimeException {
    public PageNumberOutOfRangeException(String message) {
        super(message);
    }
}
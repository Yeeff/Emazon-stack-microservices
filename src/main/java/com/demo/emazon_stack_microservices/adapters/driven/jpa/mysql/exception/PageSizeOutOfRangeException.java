package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception;

public class PageSizeOutOfRangeException extends RuntimeException {
    public PageSizeOutOfRangeException(String message) {
        super(message);
    }
}
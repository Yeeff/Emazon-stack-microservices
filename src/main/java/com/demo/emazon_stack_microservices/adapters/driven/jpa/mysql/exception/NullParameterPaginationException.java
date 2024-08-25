package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception;

public class NullParameterPaginationException  extends RuntimeException {
    public NullParameterPaginationException(String message) {
        super(message);
    }
}

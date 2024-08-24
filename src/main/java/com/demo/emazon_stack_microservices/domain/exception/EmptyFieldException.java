package com.demo.emazon_stack_microservices.domain.exception;

public class EmptyFieldException extends RuntimeException {
    public EmptyFieldException(String message) {
        super(message);
    }
}

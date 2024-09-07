package com.demo.emazon_stack_microservices.domain.exception;

public class NegativeNotAllowedException extends RuntimeException{
    public NegativeNotAllowedException(String message) {
        super(message);
    }
}

package com.demo.emazon_stack_microservices.domain.exception;

public class CharactersLongerThanExpectedException extends RuntimeException {
    public CharactersLongerThanExpectedException(String message) {
        super(message);
    }
}

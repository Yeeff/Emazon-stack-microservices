package com.pragma.arquetipobootcamp2024.domain.model;



import com.demo.emazon_stack_microservices.domain.exception.CharactersLongerThanExpectedException;
import com.demo.emazon_stack_microservices.domain.exception.EmptyFieldException;
import com.demo.emazon_stack_microservices.domain.util.DomainConstants;

import java.util.Objects;

public class Category {
    private final Long id;
    private final String  name;
    private final String description;

    public Category(Long id, String name, String description) {
        if (name.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }
        if (description.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.DESCRIPTION.toString());
        }
        if (name.length() > DomainConstants.MAX_NAME_LENGTH) {
            throw new CharactersLongerThanExpectedException(DomainConstants.Field.NAME.toString() +","+ DomainConstants.MAX_NAME_LENGTH );
        }
        if (description.length() > DomainConstants.MAX_DESCRIPTION_LENGTH) {
            throw new CharactersLongerThanExpectedException(DomainConstants.Field.DESCRIPTION.toString() +","+ DomainConstants.MAX_DESCRIPTION_LENGTH );
        }
        this.id = id;
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.description = Objects.requireNonNull(description, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}

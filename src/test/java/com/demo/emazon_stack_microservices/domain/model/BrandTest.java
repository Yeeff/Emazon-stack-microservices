package com.demo.emazon_stack_microservices.domain.model;

import com.demo.emazon_stack_microservices.domain.exception.CharactersLongerThanExpectedException;
import com.demo.emazon_stack_microservices.domain.exception.EmptyFieldException;
import com.demo.emazon_stack_microservices.domain.util.DomainConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandTest {
    private static final Long VALID_ID = 1L;
    private static final String VALID_NAME = "Valid Name";
    private static final String VALID_DESCRIPTION = "Valid Description";

    @Test
    void shouldThrowExceptionWhenNameIsEmpty() {
        String emptyName = "";

        assertThrows(EmptyFieldException.class, () ->
                        new Brand(VALID_ID, emptyName, VALID_DESCRIPTION),
                "Expected constructor to throw an exception when name is empty"
        );
    }

    @Test
    void shouldThrowExceptionWhenDescriptionIsEmpty() {
        String emptyDescription = "";

        assertThrows(EmptyFieldException.class, () ->
                        new Brand(VALID_ID, VALID_NAME, emptyDescription),
                "Expected constructor to throw an exception when description is empty"
        );
    }

    @Test
    void shouldThrowExceptionWhenNameIsTooLong() {
        String longName = "A".repeat(DomainConstants.MAX_BRAND_NAME_LENGTH + 1);

        assertThrows(CharactersLongerThanExpectedException.class, () ->
                        new Brand(VALID_ID, longName, VALID_DESCRIPTION),
                "Expected constructor to throw an exception when name is too long"
        );
    }

    @Test
    void shouldThrowExceptionWhenDescriptionIsTooLong() {
        String longDescription = "A".repeat(DomainConstants.MAX_BRAND_DESCRIPTION_LENGTH + 1);

        assertThrows(CharactersLongerThanExpectedException.class, () ->
                        new Brand(VALID_ID, VALID_NAME, longDescription),
                "Expected constructor to throw an exception when description is too long"
        );
    }

    @Test
    void shouldCreateCategoryWithValidValues() {
        assertDoesNotThrow(() ->
                        new Brand(VALID_ID, VALID_NAME, VALID_DESCRIPTION),
                "Expected constructor to succeed when valid values are provided"
        );
    }

    @Test
    void shouldNotAllowNullName() {
        assertThrows(NullPointerException.class, () ->
                        new Brand(VALID_ID, null, VALID_DESCRIPTION),
                "Expected constructor to throw NullPointerException when name is null"
        );
    }

    @Test
    void shouldNotAllowNullDescription() {
        assertThrows(NullPointerException.class, () ->
                        new Category(VALID_ID, VALID_NAME, null),
                "Expected constructor to throw NullPointerException when description is null"
        );
    }

}
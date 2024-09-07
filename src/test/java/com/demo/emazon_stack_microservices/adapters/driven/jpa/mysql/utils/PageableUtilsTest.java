package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.utils;

import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.InvalidSortDirectionException;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.NullParameterPaginationException;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.PageNumberOutOfRangeException;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.PageSizeOutOfRangeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageableUtilsTest {
    @Test
    void testValidatePageableParameters_validParameters() {
        assertDoesNotThrow(() -> PageableUtils.validatePageableParameters(10, 0, "ASC"));
        assertDoesNotThrow(() -> PageableUtils.validatePageableParameters(10, 0, "DESC"));
    }

    @Test
    void testValidatePageableParameters_nullSize() {
        assertThrows(NullParameterPaginationException.class, () ->
                PageableUtils.validatePageableParameters(null, 0, "ASC")
        );
    }

    @Test
    void testValidatePageableParameters_nullPage() {
        assertThrows(NullParameterPaginationException.class, () ->
                PageableUtils.validatePageableParameters(10, null, "ASC")
        );
    }

    @Test
    void testValidatePageableParameters_nullSortDirection() {
        assertThrows(NullParameterPaginationException.class, () ->
                PageableUtils.validatePageableParameters(10, 0, null)
        );
    }

    @Test
    void testValidatePageableParameters_invalidSortDirection() {
        assertThrows(InvalidSortDirectionException.class, () ->
                PageableUtils.validatePageableParameters(10, 0, "INVALID")
        );
    }

    @Test
    void testValidatePageableParameters_pageOutOfRange() {
        assertThrows(PageNumberOutOfRangeException.class, () ->
                PageableUtils.validatePageableParameters(10, -1, "ASC")
        );
    }

    @Test
    void testValidatePageableParameters_sizeOutOfRange() {
        assertThrows(PageSizeOutOfRangeException.class, () ->
                PageableUtils.validatePageableParameters(0, 0, "ASC")
        );
    }
}
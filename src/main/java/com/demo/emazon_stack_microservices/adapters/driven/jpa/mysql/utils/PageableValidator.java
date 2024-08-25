package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.utils;

import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.InvalidSortDirectionException;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.PageNumberOutOfRangeException;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.PageSizeOutOfRangeException;
import org.springframework.data.domain.Sort;

public class PageableValidator {
    private static final int MIN_PAGE_SIZE = 1;
    private static final int MIN_PAGE_NUMBER = 0;
    private static final String ALLOWED_VALUES = "[ASC, DESC]";

    private PageableValidator() {
        throw new IllegalStateException("Utility class");
    }

    public static void validatePageableParameters(int size, int page, String sortDirection) {
        validatePage(page);
        validateSize(size);
        validateSortDirection(sortDirection);
    }

    private static void validatePage(int page) {
        if (page < MIN_PAGE_NUMBER) {
            throw new PageNumberOutOfRangeException(String.valueOf(MIN_PAGE_NUMBER));
        }
    }

    private static void validateSize(int size) {
        if (size < MIN_PAGE_SIZE ) {
            throw new PageSizeOutOfRangeException( String.valueOf(MIN_PAGE_SIZE));
        }
    }

    private static void validateSortDirection(String sortDirection) {
        if (sortDirection != null && !sortDirection.isEmpty()) {
            try {
                Sort.Direction.fromString(sortDirection);
            } catch (IllegalArgumentException e) {
                throw new InvalidSortDirectionException(ALLOWED_VALUES);
            }
        } else {
            throw new InvalidSortDirectionException("");
        }
    }
}

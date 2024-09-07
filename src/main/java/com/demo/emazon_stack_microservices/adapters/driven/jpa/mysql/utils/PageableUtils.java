package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.utils;

import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.InvalidSortDirectionException;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.NullParameterPaginationException;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.PageNumberOutOfRangeException;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.PageSizeOutOfRangeException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableUtils {
    private static final int MIN_PAGE_SIZE = 1;
    private static final int MIN_PAGE_NUMBER = 0;
    private static final String ALLOWED_VALUES = "[ASC, DESC]";

    private enum parametersName { SIZE, PAGE, SORT_DIRECTION }


    private PageableUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void validatePageableParameters(Integer size, Integer page, String sortDirection) {

        if (size == null) {
            throw new NullParameterPaginationException(parametersName.SIZE.toString());
        }
        if (page == null) {
            throw new NullParameterPaginationException(parametersName.PAGE.toString());
        }
        if (sortDirection == null) {
            throw new NullParameterPaginationException(parametersName.SORT_DIRECTION.toString());
        }

        validatePage(page);
        validateSize(size);
        validateSortDirection(sortDirection);
    }

    public static Pageable getPageable(Integer size, Integer page, String sortDirection){
        return PageRequest.of(
                page,
                size,
                Sort.by(Sort.Direction.fromString(sortDirection), "name"));
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

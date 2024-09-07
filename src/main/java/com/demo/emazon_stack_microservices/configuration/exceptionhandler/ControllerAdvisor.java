package com.demo.emazon_stack_microservices.configuration.exceptionhandler;

import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.*;
import com.demo.emazon_stack_microservices.configuration.Constants;
import com.demo.emazon_stack_microservices.domain.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {
    @ExceptionHandler(EmptyFieldException.class)
    public ResponseEntity<ExceptionResponse> handleEmptyFieldException(EmptyFieldException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(Constants.EMPTY_FIELD_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(CharactersLongerThanExpectedException.class)
    public ResponseEntity<ExceptionResponse> handleCharactersLongerThanExpectedCharactersException(CharactersLongerThanExpectedException exception) {
        List<String> provisonalList = List.of(exception.getMessage().split(","));
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(Constants.CHARACTERS_LONGER_THAN_EXPECTED_EXCEPTION_MESSAGE, provisonalList.get(0), provisonalList.get(1)),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(CategoryNonUniqueNameException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryNonUniqueNameException(CategoryNonUniqueNameException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(BrandNonUniqueNameException.class)
    public ResponseEntity<ExceptionResponse> handleBrandNonUniqueNameException(BrandNonUniqueNameException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(NegativeNotAllowedException.class)
    public ResponseEntity<ExceptionResponse> handleNegativeNotAllowedException(NegativeNotAllowedException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(Constants.NEGATIVE_NOT_ALLOWED_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(MinCategoriesNotMetException.class)
    public ResponseEntity<ExceptionResponse> handleMinCategoriesNotMetException(MinCategoriesNotMetException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(MaxCategoriesExceededException.class)
    public ResponseEntity<ExceptionResponse> handleMaxCategoriesExceededException(MaxCategoriesExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(DuplicateCategoriesException.class)
    public ResponseEntity<ExceptionResponse> handleDuplicateCategoriesException(DuplicateCategoriesException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }



    @ExceptionHandler(InvalidSortDirectionException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidSortDirectionException(InvalidSortDirectionException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(Constants.INVALID_SORT_DIRECTION_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(PageNumberOutOfRangeException.class)
    public ResponseEntity<ExceptionResponse> handlePageNumberOutOfRangeException(PageNumberOutOfRangeException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(Constants.INVALID_PAGE_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(PageSizeOutOfRangeException.class)
    public ResponseEntity<ExceptionResponse> handlePageSizeOutOfRangeException(PageSizeOutOfRangeException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(Constants.INVALID_SIZE_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(NullParameterPaginationException.class)
    public ResponseEntity<ExceptionResponse> handleNullParameterPaginationException(NullParameterPaginationException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(Constants.NULL_PAGINATION_PARAMETER_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        StringBuilder errorMessageBuilder = new StringBuilder();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            if (errorMessageBuilder.length() > 0) {
                errorMessageBuilder.append(", ");
            }
            errorMessageBuilder.append(error.getDefaultMessage());
        });

        String errorMessage = errorMessageBuilder.toString();

        return ResponseEntity.badRequest().body(new ExceptionResponse(errorMessage,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }




    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryAlreadyExistsException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(Constants.CATEGORY_ALREADY_EXISTS_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(BrandAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleBrandAlreadyExistsException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(Constants.BRAND_ALREADY_EXISTS_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(ArticleAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleArticleAlreadyExistsException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(Constants.ARTICLE_ALREADY_EXISTS_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryNotFoundException(CategoryNotFoundException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(Constants.CATEGORY_NOT_FOUND_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNoDataFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(
                Constants.NO_DATA_FOUND_EXCEPTION_MESSAGE, HttpStatus.NOT_FOUND.toString(), LocalDateTime.now()));
    }
    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleElementNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(
                Constants.ELEMENT_NOT_FOUND_EXCEPTION_MESSAGE, HttpStatus.CONFLICT.toString(), LocalDateTime.now()));
    }

}

package com.demo.emazon_stack_microservices.domain.model;

import com.demo.emazon_stack_microservices.domain.exception.EmptyFieldException;
import com.demo.emazon_stack_microservices.domain.exception.MaxCategoriesExceededException;
import com.demo.emazon_stack_microservices.domain.exception.MinCategoriesNotMetException;
import com.demo.emazon_stack_microservices.domain.exception.NegativeNotAllowedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArticleTest {

    Category category1;
    Category category2;
    List<Category> validCategoryList;
    BigDecimal price;
    Article article;
    List<Category> tooManyCategories;
    List<Category> noCategories;

    @BeforeEach
    void setup(){
        category1 = new Category(1L, "Electronics","Electronics description");
        category2 = new Category(2L, "Toys","Toys description");

        validCategoryList = Arrays.asList(category1, category2);

        price = BigDecimal.valueOf(100);
        article = new Article(1L, "Name", "High performance laptop", price, 10L, validCategoryList);

        tooManyCategories = Arrays.asList(
                new Category(1L, "Electronics", "description"),
                new Category(2L, "Computers","description"),
                new Category(3L, "Gadgets","description"),
                new Category(4L, "Office","description")
        );

        noCategories = new ArrayList<>();

    }

    @Test
    void shouldThrowExceptionWhenArticleHasEmptyName() {
        assertThrows(EmptyFieldException.class, () -> {
            new Article(1L, "", "High performance laptop", price, 10L, validCategoryList);
        });
    }
    @Test
    void shouldThrowExceptionWhenArticleHasEmptyDescription() {

        assertThrows(EmptyFieldException.class, () -> {
            new Article(1L, "Laptop", "", price, 10L, validCategoryList);
        });
    }
    @Test
    void shouldThrowExceptionWhenArticleHasEmptyPrice() {


        assertThrows(EmptyFieldException.class, () -> {
            new Article(1L, "Laptop", "High performance laptop", null, 10L, validCategoryList);
        });
    }
    @Test
    void shouldThrowExceptionWhenArticleHasEmptyQuantity() {

        assertThrows(EmptyFieldException.class, () -> {
            new Article(1L, "Laptop", "High performance laptop", price, null, validCategoryList);
        });
    }
    @Test
    void shouldThrowExceptionWhenArticleHasEmptyCategories() {

        assertThrows(EmptyFieldException.class, () -> {
            new Article(1L, "Laptop", "High performance laptop", price, 10L, null);
        });
    }

    @Test
    void shouldThrowExceptionWhenArticleHasNegativePrice() {
        BigDecimal negativePrice = BigDecimal.valueOf(-1000.00);

        assertThrows(NegativeNotAllowedException.class, () -> {
            new Article(1L, "Laptop", "High performance laptop", negativePrice, 10L, validCategoryList);
        });
    }

    @Test
    void shouldThrowExceptionWhenArticleHasNegativeQuantity() {

        assertThrows(NegativeNotAllowedException.class, () -> {
            new Article(1L, "Laptop", "High performance laptop", price, -10L, validCategoryList);
        });
    }


    @Test
    void shouldThrowExceptionWhenArticleHasNoCategories() {

        assertThrows(MinCategoriesNotMetException.class, () -> {
            new Article(1L, "Laptop", "High performance laptop", price, 10L, noCategories);
        });
    }

    @Test
    void shouldThrowExceptionWhenArticleHasMoreThanThreeCategories() {

        assertThrows(MaxCategoriesExceededException.class, () -> {
            new Article(1L, "Laptop", "High performance laptop", price, 10L, tooManyCategories);
        });
    }

    @Test
    void shouldCreateArticleWithValidNumOfCategories() {
        Article validArticle =  new Article(1L, "Laptop", "High performance laptop", price, 10L, validCategoryList);

        assertNotNull(validArticle);
        assertEquals(2, validArticle.getCategories().size());
    }


}
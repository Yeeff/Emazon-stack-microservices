package com.demo.emazon_stack_microservices.domain.api.usecase;

import com.demo.emazon_stack_microservices.domain.exception.DuplicateCategoriesException;
import com.demo.emazon_stack_microservices.domain.model.Article;
import com.demo.emazon_stack_microservices.domain.model.Category;
import com.demo.emazon_stack_microservices.domain.spi.IArticlePersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class ArticleUseCaseTest {

    @Mock
    private IArticlePersistencePort articlePersistencePort;

    @InjectMocks
    private ArticleUseCase articleUseCase;

    Category category1;
    Category category2;
    List<Category> validList;
    BigDecimal price;
    Article article;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        category1 = new Category(1L, "Electronics","Electronics description");
        category2 = new Category(2L, "Toys","Toys description");

        validList = Arrays.asList(category1, category2);

        price = BigDecimal.valueOf(100);

        article = new Article(1L, "Laptop", "High performance laptop", price, 10L, validList);


    }
    @Test
    void shouldThrowExceptionWhenArticleHasDuplicateCategories() {

        List<Category> duplicatedCategories= Arrays.asList(category1, category1);
        article.setCategories(duplicatedCategories);

        assertThrows(DuplicateCategoriesException.class, () -> {
            articleUseCase.addArticle(article );
        });
    }

    @Test
    void shouldAddArticleWhenCategoriesAreValid() {

        articleUseCase.addArticle(article);

        verify(articlePersistencePort).addArticle(article);
    }

}
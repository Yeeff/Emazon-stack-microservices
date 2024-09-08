package com.demo.emazon_stack_microservices.domain.api.usecase;

import com.demo.emazon_stack_microservices.domain.api.IArticleServicePort;
import com.demo.emazon_stack_microservices.domain.exception.DuplicateCategoriesException;
import com.demo.emazon_stack_microservices.domain.model.Article;
import com.demo.emazon_stack_microservices.domain.model.Category;
import com.demo.emazon_stack_microservices.domain.spi.IArticlePersistencePort;
import com.demo.emazon_stack_microservices.domain.util.DomainConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArticleUseCase implements IArticleServicePort {
    private final IArticlePersistencePort articlePersistencePort;

    public ArticleUseCase(IArticlePersistencePort articlePersistencePort) {
        this.articlePersistencePort = articlePersistencePort;
    }

    @Override
    public void addArticle(Article article) {

        Set<Long> uniqueCategoryIds = new HashSet<>();

        for (Category category : article.getCategories()) {
            if (!uniqueCategoryIds.add(category.getId())) {
                throw new DuplicateCategoriesException(DomainConstants.DUPLICATED_CATEGORIES_MESSAGE);
            }
        }

        articlePersistencePort.addArticle(article);
    }

    @Override
    public List<Article> getAllArticles(int page, int size, String sortDirection) {
        return articlePersistencePort.getAllArticles(page,size,sortDirection);
    }

    @Override
    public Article getArticle(String articleName) {
        return articlePersistencePort.getArticle(articleName);
    }

    @Override
    public List<Article> getAllArticlesByCategory(Integer page, Integer size, String sortDirection, String categoryName) {
        return articlePersistencePort.getAllArticlesByCategory(page,size, sortDirection,categoryName);
    }

    @Override
    public List<Article> getAllArticlesByBrand(Integer page, Integer size, String sortDirection, String brandName) {
        return articlePersistencePort.getAllArticlesByBrand(page,size,  sortDirection, brandName);
    }


}

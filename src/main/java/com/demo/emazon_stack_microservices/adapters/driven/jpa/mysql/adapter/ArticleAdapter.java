package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.adapter;


import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.entity.ArticleEntity;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.entity.BrandEntity;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.exception.*;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.mapper.IArticleEntityMapper;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.mapper.IBrandEntityMapper;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.repository.IArticleRepository;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.repository.IBrandRepository;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.repository.ICategoryRepository;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.utils.PageableUtils;
import com.demo.emazon_stack_microservices.domain.model.Article;
import com.demo.emazon_stack_microservices.domain.model.Category;
import com.demo.emazon_stack_microservices.domain.spi.IArticlePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ArticleAdapter implements IArticlePersistencePort {
    private final IArticleRepository articleRepository;
    private final ICategoryRepository categoryRepository;
    private final IBrandRepository brandRepository;

    private final IArticleEntityMapper articleEntityMapper;
    private final ICategoryEntityMapper categoryEntityMapper;
    private final IBrandEntityMapper brandEntityMapper;

    @Override
    public void addArticle(Article article) {
        if (articleRepository.findByName(article.getName()).isPresent()) {
            throw new ArticleAlreadyExistsException();
        }

        populateCategories(article);

        BrandEntity brand = brandRepository.findById(article.getBrand().getId())
                .orElseThrow();
        article.setBrand(brandEntityMapper.toModel(brand));

        articleRepository.save(articleEntityMapper.toEntity(article));

    }

    @Override
    public Boolean existsByName(String name) {
        return articleRepository.existsByName(name);
    }

    @Override
    public List<Article> getAllArticles(int page, int size, String sortDirection) {

        PageableUtils.validatePageableParameters(size,page,sortDirection);

        Pageable pageable = PageableUtils.getPageable(size,page,sortDirection);

        List<ArticleEntity> articles = articleRepository.findAll(pageable).getContent();
        if (articles.isEmpty()) {
            throw new NoDataFoundException();
        }

        return articleEntityMapper.toModelList(articles);
    }

    @Override
    public Article getArticle(String articleName) {
        ArticleEntity article = articleRepository.findByNameContaining(articleName).orElseThrow(ElementNotFoundException::new);
        return articleEntityMapper.toModel(article);    }

    @Override
    public List<Article> getAllArticlesByCategory(Integer page, Integer size, String sortDirection, String categoryName) {
        PageableUtils.validatePageableParameters(size,page,sortDirection);

        Pageable pageable = PageableUtils.getPageable(size,page,sortDirection);

        List<ArticleEntity> articles = articleRepository.findAllByCategoryName(categoryName, pageable);
        if (articles.isEmpty()) {
            throw new NoDataFoundException();
        }

        return articleEntityMapper.toModelList(articles);
    }

    @Override
    public List<Article> getAllArticlesByBrand(Integer page, Integer size, String sortDirection, String brandName) {
        PageableUtils.validatePageableParameters(size,page,sortDirection);

        Pageable pageable = PageableUtils.getPageable(size,page,sortDirection);

        List<ArticleEntity> articles = articleRepository.findAllByBrandNameContaining(brandName, pageable).getContent();
        if (articles.isEmpty()) {
            throw new NoDataFoundException();
        }

        return articleEntityMapper.toModelList(articles);
    }

    private Article populateCategories(Article article) {

        List<Long> categoryIds = article.getCategories().stream()
                .map(Category::getId)
                .toList();

        List<CategoryEntity> fetchedCategories = categoryRepository.findAllByIdIn(categoryIds);

        Set<Long> fetchedIds = fetchedCategories.stream()
                .map(CategoryEntity::getId)
                .collect(Collectors.toSet());

        List<Long> missingIds = categoryIds.stream()
                .filter(id -> !fetchedIds.contains(id))
                .toList();

        if (!missingIds.isEmpty()) {
            throw new CategoryNotFoundException(missingIds.toString());
        }

        article.setCategories(categoryEntityMapper.toModelList(fetchedCategories));

        return article;
    }
}

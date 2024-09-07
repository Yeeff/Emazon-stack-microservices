package com.demo.emazon_stack_microservices.configuration;

import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.adapter.ArticleAdapter;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.adapter.BrandAdapter;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.adapter.CategoryAdapter;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.mapper.IArticleEntityMapper;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.mapper.IBrandEntityMapper;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.repository.IArticleRepository;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.repository.IBrandRepository;
import com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.repository.ICategoryRepository;
import com.demo.emazon_stack_microservices.domain.api.IArticleServicePort;
import com.demo.emazon_stack_microservices.domain.api.IBrandServicePort;
import com.demo.emazon_stack_microservices.domain.api.ICategoryServicePort;
import com.demo.emazon_stack_microservices.domain.api.usecase.ArticleUseCase;
import com.demo.emazon_stack_microservices.domain.api.usecase.BrandUseCase;
import com.demo.emazon_stack_microservices.domain.api.usecase.CategoryUseCase;
import com.demo.emazon_stack_microservices.domain.spi.IArticlePersistencePort;
import com.demo.emazon_stack_microservices.domain.spi.IBrandPersistencePort;
import com.demo.emazon_stack_microservices.domain.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    private final IBrandRepository brandRepository;
    private final IBrandEntityMapper brandyEntityMapper;

    private final IArticleRepository articleRepository;
    private final IArticleEntityMapper articleEntityMapper;

    @Bean
    public ICategoryPersistencePort categoryPersistencePort() {
        return new CategoryAdapter(categoryRepository, categoryEntityMapper);
    }
    @Bean
    public ICategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public IArticleServicePort articleServicePort(){
        return new ArticleUseCase(articlePersistencePort());
    }
    @Bean
    public IArticlePersistencePort articlePersistencePort(){
        return new ArticleAdapter( articleRepository, categoryRepository, articleEntityMapper, categoryEntityMapper );
    }


    @Bean
    public IBrandPersistencePort brandPersistencePort() {
        return new BrandAdapter(brandRepository, brandyEntityMapper);
    }
    @Bean
    public IBrandServicePort brandServicePort() {
        return new BrandUseCase(brandPersistencePort());
    }
}

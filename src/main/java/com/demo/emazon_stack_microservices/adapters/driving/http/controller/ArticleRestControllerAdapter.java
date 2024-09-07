package com.demo.emazon_stack_microservices.adapters.driving.http.controller;


import com.demo.emazon_stack_microservices.adapters.driving.http.dto.request.AddArticleRequest;
import com.demo.emazon_stack_microservices.adapters.driving.http.mapper.IArticleRequestMapper;
import com.demo.emazon_stack_microservices.domain.api.IArticleServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleRestControllerAdapter {

    private final IArticleServicePort articleServicePort;
    private final IArticleRequestMapper articleRequestMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addArticle(@Valid @RequestBody AddArticleRequest request) {
        articleServicePort.addArticle(articleRequestMapper.addRequestToArticle(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

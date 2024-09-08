package com.demo.emazon_stack_microservices.adapters.driving.http.controller;


import com.demo.emazon_stack_microservices.adapters.driving.http.dto.request.AddArticleRequest;
import com.demo.emazon_stack_microservices.adapters.driving.http.dto.response.ArticleResponse;
import com.demo.emazon_stack_microservices.adapters.driving.http.mapper.IArticleRequestMapper;
import com.demo.emazon_stack_microservices.adapters.driving.http.mapper.IArticleResponseMapper;
import com.demo.emazon_stack_microservices.domain.api.IArticleServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleRestControllerAdapter {

    private final IArticleServicePort articleServicePort;
    private final IArticleRequestMapper articleRequestMapper;
    private final IArticleResponseMapper articleResponseMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addArticle(@Valid @RequestBody AddArticleRequest request) {
        articleServicePort.addArticle(articleRequestMapper.addRequestToArticle(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<ArticleResponse>> getAllArticles(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortDirection
    ) {
        return ResponseEntity.ok(articleResponseMapper.toArticledResponseList(articleServicePort.getAllArticles(page, size,sortDirection)));
    }

    @GetMapping("/search/{articleName}")
    public ResponseEntity<ArticleResponse> getArticle(@PathVariable String articleName) {
        return ResponseEntity.ok(articleResponseMapper.toArticledResponse(articleServicePort.getArticle(articleName)));
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<ArticleResponse>> getAllArticlesByCategory(@RequestParam Integer page,
                                                                          @RequestParam Integer size,
                                                                          @RequestParam String sortDirection,
                                                                          @PathVariable String categoryName) {
        return ResponseEntity.ok(articleResponseMapper.
                toArticledResponseList(articleServicePort.getAllArticlesByCategory(page, size,sortDirection, categoryName)));
    }

    @GetMapping("/brand/{brandName}")
    public ResponseEntity<List<ArticleResponse>> getAllArticlesByBrand(@RequestParam Integer page,
                                                                          @RequestParam Integer size,
                                                                          @RequestParam String sortDirection,
                                                                          @PathVariable String brandName) {
        return ResponseEntity.ok(articleResponseMapper.
                toArticledResponseList(articleServicePort.getAllArticlesByBrand(page, size,sortDirection, brandName)));
    }

}

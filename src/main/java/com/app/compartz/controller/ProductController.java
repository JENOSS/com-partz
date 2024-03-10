package com.app.compartz.controller;

import com.app.compartz.dto.product.*;
import com.app.compartz.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    public ResponseEntity<Page<ProductDto>> getProducts(ProductRequest request) {
        return ResponseEntity.ok(productService.getProducts(request));
    }

    @GetMapping("/recommends")
    public ResponseEntity<List<RecommendDto>> getRecommends() {
        return ResponseEntity.ok(productService.getRecommends());
    }

    @GetMapping("/raffles")
    public ResponseEntity<RaffleDto> getRaffles() {
        return ResponseEntity.ok(productService.getRaffle());
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        return ResponseEntity.ok(productService.getCategories());
    }

}

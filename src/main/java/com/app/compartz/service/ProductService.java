package com.app.compartz.service;

import com.app.compartz.domain.product.repository.ProductRepository;
import com.app.compartz.dto.product.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ProductService {
    Page<ProductDto> getProducts(ProductRequest request);
    RaffleDto getRaffle();
    List<RecommendDto> getRecommends();
    List<CategoryDto> getCategories();
}

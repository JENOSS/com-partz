package com.app.compartz.service.impl;

import com.app.compartz.domain.product.converter.CategoryDtoConverter;
import com.app.compartz.domain.product.converter.ProductDtoConverter;
import com.app.compartz.domain.product.converter.RaffleDtoConverter;
import com.app.compartz.domain.product.converter.RecommendDtoConverter;
import com.app.compartz.domain.product.repository.CategoryRepository;
import com.app.compartz.domain.product.repository.ProductRepository;
import com.app.compartz.domain.product.repository.RaffleRepository;
import com.app.compartz.domain.product.repository.RecommendRepository;
import com.app.compartz.dto.product.*;
import com.app.compartz.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final RaffleRepository raffleRepository;
    private final RecommendRepository recommendRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<ProductDto> getProducts(ProductRequest request) {
        return productRepository.findPageBySearch(request);
    }

    @Override
    public ProductDto getProduct(Long productId) {
        return productRepository.findById(productId)
                .map(ProductDtoConverter::new)
                .map(ProductDtoConverter::convert)
                .orElseThrow(() -> new NoSuchElementException("no items"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecommendDto> getRecommends() {
        return recommendRepository.findAll().stream()
                .map(RecommendDtoConverter::new)
                .map(RecommendDtoConverter::convert)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public RaffleDto getRaffle() {
        return raffleRepository.findFirstByOrderByIdDesc()
                .map(RaffleDtoConverter::new)
                .map(RaffleDtoConverter::convert)
                .orElseThrow(() -> new NoSuchElementException("no items"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDto> getCategories() {
        return categoryRepository.findByOrderBySortOrder().stream()
                .map(CategoryDtoConverter::new)
                .map(CategoryDtoConverter::convert)
                .toList();
    }


}

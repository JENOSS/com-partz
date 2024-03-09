package com.app.compartz.domain.product.repository;

import com.app.compartz.dto.product.ProductDto;
import com.app.compartz.dto.product.ProductRequest;
import org.springframework.data.domain.Page;

public interface CustomProductRepository {
    Page<ProductDto> findPageBySearch(ProductRequest request);
}

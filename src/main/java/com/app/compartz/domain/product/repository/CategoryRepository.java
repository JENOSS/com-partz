package com.app.compartz.domain.product.repository;

import com.app.compartz.domain.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByOrderBySortOrder();
}

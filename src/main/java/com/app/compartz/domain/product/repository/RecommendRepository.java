package com.app.compartz.domain.product.repository;

import com.app.compartz.domain.product.model.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendRepository extends JpaRepository<Recommend, Long> {
}

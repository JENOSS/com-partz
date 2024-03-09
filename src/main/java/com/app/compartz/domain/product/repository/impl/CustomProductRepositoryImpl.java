package com.app.compartz.domain.product.repository.impl;

import com.app.compartz.domain.product.model.Product;
import com.app.compartz.domain.product.model.SortType;
import com.app.compartz.domain.product.repository.CustomProductRepository;
import com.app.compartz.dto.product.ProductDto;
import com.app.compartz.dto.product.ProductRequest;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.binding.QuerydslPredicateBuilder;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.function.Consumer;

import static com.app.compartz.domain.product.model.QProduct.product;

@Repository
public class CustomProductRepositoryImpl  implements CustomProductRepository {
    private final JPAQueryFactory queryFactory;

    public CustomProductRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<ProductDto> findPageBySearch(ProductRequest request) {
        var pageRequest = PageRequest.of(request.getPage(), request.getSize());
        var result = queryFactory
                .from(product)
                .where(this.getSearchPredicate(request))
                .orderBy(this.getOrderPredicate(request.getSortType()))
                .limit(request.getSize()).offset((long)request.getPage() * (long)request.getSize())
                .fetchResults();
        return new PageImpl(result.getResults(), pageRequest, result.getTotal());
    }

    private BooleanBuilder getSearchPredicate(ProductRequest request) {
        var booleanBuilder = new BooleanBuilder();

        if (Objects.nonNull(request.getCategoryId())) {
            booleanBuilder.and(product.categoryId.eq(request.getCategoryId()));
        }

        return booleanBuilder;
    }

    private OrderSpecifier getOrderPredicate(String sortType) {
        if (sortType.equals(SortType.PRICE_ASC.name())) {
            return product.price.asc();
        }

        if (sortType.equals(SortType.PRICE_DESC.name())) {
            return product.price.desc();
        }

        return product.id.desc();

    }
}

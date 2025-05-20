package com.aescudero.capitole_inditex.adapter.out.persistence.repository;

import com.aescudero.capitole_inditex.adapter.out.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {
    @Query(""" 
            SELECT price FROM PriceEntity price
            WHERE price.brand.id = :brandId
            AND price.product.id = :productId
            AND :applicationDate BETWEEN price.startDate AND price.endDate
            ORDER BY price.priority DESC LIMIT 1""")

    Optional<PriceEntity> findByBrandIdAndProductIdAndApplicationDate(
            @Param("brandId") Long brandId,
            @Param("productId") Long productId,
            @Param("applicationDate") LocalDateTime applicationDate
    );

}

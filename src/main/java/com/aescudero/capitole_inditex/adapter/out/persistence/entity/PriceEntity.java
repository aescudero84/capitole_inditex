package com.aescudero.capitole_inditex.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
@NoArgsConstructor
@Getter
@Setter
public class PriceEntity {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private BrandEntity brand;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDate;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_list_id")
    private PriceListEntity priceList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    private Integer priority;
    private BigDecimal price;
    private String currency;
}

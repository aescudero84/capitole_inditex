package com.aescudero.capitole_inditex.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
public class Price {
    @NonNull
    private Brand brand;
    @NonNull
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @NonNull
    private PriceList priceList;
    @NonNull
    private Product product;
    @NonNull
    private Priority priority;
    @NonNull
    private BigDecimal price;
    @NonNull
    private Currency currency;
}

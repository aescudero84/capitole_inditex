package com.aescudero.capitole_inditex.adapter.out.persistence.mapper;

import com.aescudero.capitole_inditex.adapter.out.persistence.entity.PriceEntity;
import com.aescudero.capitole_inditex.domain.model.Currency;
import com.aescudero.capitole_inditex.domain.model.Price;
import com.aescudero.capitole_inditex.domain.model.Priority;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class PriceMapper {

    private final BrandMapper brandMapper;
    private final ProductMapper productMapper;
    private final PriceListMapper priceListMapper;

    public PriceMapper(BrandMapper brandMapper, ProductMapper productMapper, PriceListMapper priceListMapper) {
        this.brandMapper = brandMapper;
        this.productMapper = productMapper;
        this.priceListMapper = priceListMapper;
    }

    public Price toDomain(PriceEntity entity) {
        return Price.builder()
                .brand(brandMapper.toDomain(entity.getBrand()))
                .product(productMapper.toDomain(entity.getProduct()))
                .priceList(priceListMapper.toDomain(entity.getPriceList()))
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .priority(Priority.lookup(entity.getPriority()))
                .price(roundPrice(entity.getPrice()))
                .currency(Currency.lookup(entity.getCurrency()))
                .build();
    }

    private BigDecimal roundPrice(BigDecimal price) {
        return price.setScale(2, RoundingMode.HALF_UP);
    }
}

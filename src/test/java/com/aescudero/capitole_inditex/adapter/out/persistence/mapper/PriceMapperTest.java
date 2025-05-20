package com.aescudero.capitole_inditex.adapter.out.persistence.mapper;

import com.aescudero.capitole_inditex.adapter.out.persistence.entity.BrandEntity;
import com.aescudero.capitole_inditex.adapter.out.persistence.entity.PriceEntity;
import com.aescudero.capitole_inditex.adapter.out.persistence.entity.PriceListEntity;
import com.aescudero.capitole_inditex.adapter.out.persistence.entity.ProductEntity;
import com.aescudero.capitole_inditex.domain.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PriceMapperTest {

    @Mock
    private BrandMapper brandMapper;

    @Mock
    private ProductMapper productMapper;

    @Mock
    private PriceListMapper priceListMapper;

    @InjectMocks
    private PriceMapper priceMapper;

    @Test
    void shouldMapPriceEntityToDomainPrice() {
        // given
        PriceEntity entity = mock(PriceEntity.class);
        BigDecimal expectedPrice = new BigDecimal(1.0).setScale(2, RoundingMode.HALF_UP);

        BrandEntity brandEntity = mock(BrandEntity.class);
        ProductEntity productEntity = mock(ProductEntity.class);
        PriceListEntity priceListEntity = mock(PriceListEntity.class);

        when(entity.getBrand()).thenReturn(brandEntity);
        when(entity.getProduct()).thenReturn(productEntity);
        when(entity.getPriceList()).thenReturn(priceListEntity);
        when(entity.getStartDate()).thenReturn(LocalDateTime.of(2025, 1, 1, 0, 0));
        when(entity.getEndDate()).thenReturn(LocalDateTime.of(2025, 12, 31, 23, 59));
        when(entity.getPriority()).thenReturn(Priority.HIGH.getValue());
        when(entity.getPrice()).thenReturn(expectedPrice);
        when(entity.getCurrency()).thenReturn(Currency.USD.getCode());

        Brand brand = mock(Brand.class);
        Product product = mock(Product.class);
        PriceList priceList = mock(PriceList.class);

        when(brandMapper.toDomain(brandEntity)).thenReturn(brand);
        when(productMapper.toDomain(productEntity)).thenReturn(product);
        when(priceListMapper.toDomain(priceListEntity)).thenReturn(priceList);

        // when
        Price result = priceMapper.toDomain(entity);

        // then
        assertNotNull(result);
        assertEquals(brand, result.getBrand());
        assertEquals(product, result.getProduct());
        assertEquals(priceList, result.getPriceList());
        assertEquals(LocalDateTime.of(2025, 1, 1, 0, 0), result.getStartDate());
        assertEquals(LocalDateTime.of(2025, 12, 31, 23, 59), result.getEndDate());
        assertEquals(Priority.HIGH, result.getPriority());
        assertEquals(expectedPrice, result.getPrice());
        assertEquals(Currency.USD, result.getCurrency());

        verify(brandMapper).toDomain(brandEntity);
        verify(productMapper).toDomain(productEntity);
        verify(priceListMapper).toDomain(priceListEntity);
    }
}

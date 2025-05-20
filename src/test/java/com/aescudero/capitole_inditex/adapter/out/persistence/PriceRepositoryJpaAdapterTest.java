package com.aescudero.capitole_inditex.adapter.out.persistence;

import com.aescudero.capitole_inditex.adapter.out.persistence.entity.PriceEntity;
import com.aescudero.capitole_inditex.adapter.out.persistence.mapper.PriceMapper;
import com.aescudero.capitole_inditex.adapter.out.persistence.repository.PriceJpaRepository;
import com.aescudero.capitole_inditex.domain.model.Price;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PriceRepositoryJpaAdapterTest {

    @Mock
    private PriceJpaRepository priceJpaRepository;

    @Mock
    private PriceMapper priceMapper;

    @InjectMocks
    private PriceRepositoryJpaAdapter adapter;

    @Test
    void shouldReturnPriceWhenEntityIsFound() {
        // given
        Long brandId = 1L;
        Long productId = 2L;
        LocalDateTime applicationDate = LocalDateTime.now();

        PriceEntity priceEntity = mock(PriceEntity.class);
        Price price = mock(Price.class);

        when(priceJpaRepository.findByBrandIdAndProductIdAndApplicationDate(brandId, productId, applicationDate))
                .thenReturn(Optional.of(priceEntity));
        when(priceMapper.toDomain(priceEntity)).thenReturn(price);

        // when
        Optional<Price> result = adapter.findPrice(brandId, productId, applicationDate);

        // then
        assertTrue(result.isPresent());
        assertEquals(price, result.get());

        verify(priceJpaRepository).findByBrandIdAndProductIdAndApplicationDate(brandId, productId, applicationDate);
        verify(priceMapper).toDomain(priceEntity);
    }

    @Test
    void shouldReturnEmptyWhenEntityIsNotFound() {
        // given
        Long brandId = 1L;
        Long productId = 2L;
        LocalDateTime applicationDate = LocalDateTime.now();

        when(priceJpaRepository.findByBrandIdAndProductIdAndApplicationDate(brandId, productId, applicationDate))
                .thenReturn(Optional.empty());

        // when
        Optional<Price> result = adapter.findPrice(brandId, productId, applicationDate);

        // then
        assertTrue(result.isEmpty());

        verify(priceJpaRepository).findByBrandIdAndProductIdAndApplicationDate(brandId, productId, applicationDate);
        verifyNoInteractions(priceMapper);
    }
}
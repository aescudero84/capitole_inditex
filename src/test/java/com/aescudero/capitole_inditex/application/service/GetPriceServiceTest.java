package com.aescudero.capitole_inditex.application.service;

import com.aescudero.capitole_inditex.application.port.in.GetPriceQuery;
import com.aescudero.capitole_inditex.application.port.out.PriceRepository;
import com.aescudero.capitole_inditex.domain.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetPriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private GetPriceService getPriceService;

    @Test
    void shouldReturnPriceWhenIsFound() {
        // given
        Long brandId = 1L;
        Long productId = 2L;
        LocalDateTime applicationDate = LocalDateTime.now();

        GetPriceQuery query = new GetPriceQuery(brandId, productId, applicationDate);

        Brand brand = Brand.builder().id(1L).name("Marca 1").build();
        Product product = Product.builder().id(1L).description("Producto 1").build();
        PriceList priceList = PriceList.builder().id(1L).description("Tarifa 1").build();
        Price expectedPrice = Price.builder()
                .brand(brand)
                .product(product)
                .priceList(priceList)
                .priority(Priority.HIGH)
                .currency(Currency.EUR)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusMonths(1))
                .price(new BigDecimal(1.0))
                .build();

        // when
        when(priceRepository.findPrice(brandId, productId, applicationDate))
                .thenReturn(Optional.of(expectedPrice));

        Optional<Price> actualPrice = getPriceService.getPrice(query);

        // then
        assertTrue(actualPrice.isPresent());
        assertEquals(expectedPrice, actualPrice.get());

        verify(priceRepository, times(1)).findPrice(brandId, productId, applicationDate);
    }

    @Test
    void shouldReturnEmptyWhenPriceIsNotFound() {
        // given
        Long brandId = 1L;
        Long productId = 2L;
        LocalDateTime applicationDate = LocalDateTime.now();

        GetPriceQuery query = new GetPriceQuery(brandId, productId, applicationDate);

        // when
        when(priceRepository.findPrice(brandId, productId, applicationDate))
                .thenReturn(Optional.empty());

        Optional<Price> actualPrice = getPriceService.getPrice(query);

        // then
        assertFalse(actualPrice.isPresent());

        verify(priceRepository, times(1)).findPrice(brandId, productId, applicationDate);
    }
}

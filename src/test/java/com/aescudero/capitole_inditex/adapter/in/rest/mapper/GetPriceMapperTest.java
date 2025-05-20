package com.aescudero.capitole_inditex.adapter.in.rest.mapper;

import com.aescudero.capitole_inditex.adapter.in.rest.dto.GetPriceDto;
import com.aescudero.capitole_inditex.adapter.in.rest.dto.GetPriceRequestDto;
import com.aescudero.capitole_inditex.application.port.in.GetPriceQuery;
import com.aescudero.capitole_inditex.domain.model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GetPriceMapperTest {

    private final GetPriceMapper mapper = new GetPriceMapper();

    @Test
    void shouldMapDomainPriceToGetPriceDto() {
        // given
        Brand brand = Brand.builder().id(1L).name("brand").build();
        Product product = Product.builder().id(2L).description("product").build();
        PriceList priceList = PriceList.builder().id(3L).description("priceList").build();

        Price price = Price.builder()
                .product(product)
                .brand(brand)
                .priceList(priceList)
                .startDate(LocalDateTime.of(2025, 1, 1, 0, 0))
                .endDate(LocalDateTime.of(2025, 12, 31, 23, 59))
                .price(new BigDecimal(1.00).setScale(2, RoundingMode.HALF_UP))
                .priority(Priority.HIGH)
                .currency(Currency.EUR)
                .build();

        // when
        GetPriceDto dto = mapper.toDto(price);

        // then
        assertNotNull(dto);
        assertEquals(1L, dto.brand());
        assertEquals(2L, dto.product());
        assertEquals(3L, dto.priceList());
        assertEquals("2025-01-01T00:00:00", dto.startDate());
        assertEquals("2025-12-31T23:59:00", dto.endDate());
        assertEquals("1.00", dto.price());
        assertEquals("EUR", dto.currency());
    }

    @Test
    void shouldMapGetPriceRequestDtoToGetPriceQuery() {
        // given
        String dateStr = "2025-01-01T00:00:00";
        GetPriceRequestDto requestDto = new GetPriceRequestDto(1L, 2L, dateStr);

        // when
        GetPriceQuery query = mapper.toQuery(requestDto);

        // then
        assertNotNull(query);
        assertEquals(1L, query.brandId());
        assertEquals(2L, query.productId());
        assertEquals(LocalDateTime.parse(dateStr), query.applicationDate());
    }
}

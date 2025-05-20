package com.aescudero.capitole_inditex.adapter.out.persistence.mapper;

import com.aescudero.capitole_inditex.adapter.out.persistence.entity.PriceListEntity;
import com.aescudero.capitole_inditex.domain.model.PriceList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class PriceListMapperTest {

    private final PriceListMapper priceListMapper = new PriceListMapper();

    @Test
    void shouldMapPriceListEntityToDomainPriceList() {
        // given
        PriceListEntity entity = mock(PriceListEntity.class);

        when(entity.getId()).thenReturn(1L);
        when(entity.getDescription()).thenReturn("Tarifa 1");

        // when
        PriceList result = priceListMapper.toDomain(entity);

        // then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Tarifa 1", result.getDescription());
    }
}

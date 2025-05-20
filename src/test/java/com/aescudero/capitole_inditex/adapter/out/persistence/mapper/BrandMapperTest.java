package com.aescudero.capitole_inditex.adapter.out.persistence.mapper;

import com.aescudero.capitole_inditex.adapter.out.persistence.entity.BrandEntity;
import com.aescudero.capitole_inditex.domain.model.Brand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class BrandMapperTest {

    private final BrandMapper brandMapper = new BrandMapper();

    @Test
    void shouldMapBrandEntityToDomainBrand() {
        // given
        BrandEntity entity = mock(BrandEntity.class);

        when(entity.getId()).thenReturn(1L);
        when(entity.getName()).thenReturn("Marca 1");

        // when
        Brand result = brandMapper.toDomain(entity);

        // then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Marca 1", result.getName());
    }
}

package com.aescudero.capitole_inditex.adapter.out.persistence.mapper;

import com.aescudero.capitole_inditex.adapter.out.persistence.entity.ProductEntity;
import com.aescudero.capitole_inditex.domain.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ProductMapperTest {

    private final ProductMapper productMapper = new ProductMapper();

    @Test
    void shouldMapProductEntityToDomainProduct() {
        // given
        ProductEntity entity = mock(ProductEntity.class);

        when(entity.getId()).thenReturn(1L);
        when(entity.getDescription()).thenReturn("Product 1");

        // when
        Product result = productMapper.toDomain(entity);

        // then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Product 1", result.getDescription());
    }
}

package com.aescudero.capitole_inditex.adapter.out.persistence.mapper;

import com.aescudero.capitole_inditex.adapter.out.persistence.entity.ProductEntity;
import com.aescudero.capitole_inditex.domain.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toDomain(ProductEntity entity) {
        return Product.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .build();
    }
}

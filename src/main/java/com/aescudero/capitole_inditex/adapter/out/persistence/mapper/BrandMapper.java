package com.aescudero.capitole_inditex.adapter.out.persistence.mapper;

import com.aescudero.capitole_inditex.adapter.out.persistence.entity.BrandEntity;
import com.aescudero.capitole_inditex.domain.model.Brand;
import org.springframework.stereotype.Component;

@Component
public class BrandMapper {

    public Brand toDomain(BrandEntity entity) {
        return Brand.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}

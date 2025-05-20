package com.aescudero.capitole_inditex.adapter.out.persistence.mapper;

import com.aescudero.capitole_inditex.adapter.out.persistence.entity.PriceListEntity;
import com.aescudero.capitole_inditex.domain.model.PriceList;
import org.springframework.stereotype.Component;

@Component
public class PriceListMapper {

    public PriceList toDomain(PriceListEntity entity) {
        return PriceList.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .build();
    }
}

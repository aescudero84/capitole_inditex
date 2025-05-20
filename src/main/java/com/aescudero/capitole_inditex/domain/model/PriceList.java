package com.aescudero.capitole_inditex.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Builder
@Getter
public class PriceList {
    @NonNull
    private Long id;
    @NonNull
    private String description;
}

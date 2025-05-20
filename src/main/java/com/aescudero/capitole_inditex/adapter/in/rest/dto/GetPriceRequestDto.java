package com.aescudero.capitole_inditex.adapter.in.rest.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record GetPriceRequestDto (
        @NotNull @Positive(message="Incorrect brandId format") Long brandId,
        @NotNull @Positive(message="Incorrect productId format") Long productId,
        @NotNull String applicationDate) {}

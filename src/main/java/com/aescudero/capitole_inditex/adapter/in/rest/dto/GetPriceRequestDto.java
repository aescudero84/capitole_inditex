package com.aescudero.capitole_inditex.adapter.in.rest.dto;

import com.aescudero.capitole_inditex.adapter.in.rest.validator.ValidDate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record GetPriceRequestDto (
        @NotNull(message="This field is mandatory") @Positive(message="Incorrect format") Long brandId,
        @NotNull(message="This field is mandatory") @Positive(message="Incorrect format") Long productId,
        @NotNull(message="This field is mandatory") @ValidDate String applicationDate) {}

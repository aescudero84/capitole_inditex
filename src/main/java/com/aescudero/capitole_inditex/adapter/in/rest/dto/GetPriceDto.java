package com.aescudero.capitole_inditex.adapter.in.rest.dto;

public record GetPriceDto (
        Long product,
        Long brand,
        Long priceList,
        String startDate,
        String endDate,
        String price,
        String currency
) {}

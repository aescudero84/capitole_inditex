package com.aescudero.capitole_inditex.adapter.in.rest.mapper;

import com.aescudero.capitole_inditex.adapter.in.rest.dto.GetPriceDto;
import com.aescudero.capitole_inditex.adapter.in.rest.dto.GetPriceRequestDto;
import com.aescudero.capitole_inditex.application.port.in.GetPriceQuery;
import com.aescudero.capitole_inditex.domain.model.Price;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class GetPriceMapper {

    public GetPriceDto toDto(Price domainPrice) {
        return new GetPriceDto(
                domainPrice.getProduct().getId(),
                domainPrice.getBrand().getId(),
                domainPrice.getPriceList().getId(),
                toStringDate(domainPrice.getStartDate()),
                toStringDate(domainPrice.getEndDate()),
                domainPrice.getPrice().toPlainString(),
                domainPrice.getCurrency().getCode());
    }

    public GetPriceQuery toQuery(GetPriceRequestDto dto) {
        return new GetPriceQuery(
                dto.brandId(),
                dto.productId(),
                toLocalDateTime(dto.applicationDate()));
    }

    private LocalDateTime toLocalDateTime(String strDate) {
        return LocalDateTime.parse(strDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    private String toStringDate(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}


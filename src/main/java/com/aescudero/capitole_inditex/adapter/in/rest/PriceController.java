package com.aescudero.capitole_inditex.adapter.in.rest;

import com.aescudero.capitole_inditex.adapter.in.rest.dto.GetPriceDto;
import com.aescudero.capitole_inditex.adapter.in.rest.dto.GetPriceRequestDto;
import com.aescudero.capitole_inditex.adapter.in.rest.exception.NotFoundException;
import com.aescudero.capitole_inditex.adapter.in.rest.mapper.GetPriceMapper;
import com.aescudero.capitole_inditex.application.port.in.GetPriceUseCase;
import com.aescudero.capitole_inditex.domain.model.Price;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/prices")
@Validated
public class PriceController {

    private final GetPriceUseCase getPriceUseCase;
    private final GetPriceMapper getPriceMapper;

    public PriceController(GetPriceUseCase getPriceUseCase, GetPriceMapper getPriceMapper) {
        this.getPriceUseCase = getPriceUseCase;
        this.getPriceMapper = getPriceMapper;
    }

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public GetPriceDto findPrice(@Valid @ModelAttribute GetPriceRequestDto getPriceRequestDto) {
        Optional<Price> price = getPriceUseCase.getPrice(getPriceMapper.toQuery(getPriceRequestDto));

        if (price.isEmpty()) {
            throw new NotFoundException("Price not found for the requested search parameters");
        }

        return getPriceMapper.toDto(price.get());
    }
}

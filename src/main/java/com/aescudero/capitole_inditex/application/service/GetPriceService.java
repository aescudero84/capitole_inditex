package com.aescudero.capitole_inditex.application.service;

import com.aescudero.capitole_inditex.application.port.in.GetPriceQuery;
import com.aescudero.capitole_inditex.application.port.in.GetPriceUseCase;
import com.aescudero.capitole_inditex.application.port.out.PriceRepository;
import com.aescudero.capitole_inditex.domain.model.Price;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetPriceService implements GetPriceUseCase {

    PriceRepository priceRepository;

    public GetPriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Optional<Price> getPrice(GetPriceQuery getPriceQuery) {
        return priceRepository.findPrice(
                getPriceQuery.brandId(), getPriceQuery.productId(), getPriceQuery.applicationDate());
    }
}

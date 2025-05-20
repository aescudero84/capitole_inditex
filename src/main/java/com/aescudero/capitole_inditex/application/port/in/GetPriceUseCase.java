package com.aescudero.capitole_inditex.application.port.in;

import com.aescudero.capitole_inditex.domain.model.Price;

import java.util.Optional;

public interface GetPriceUseCase {

    Optional<Price> getPrice(GetPriceQuery getPriceQuery);
}

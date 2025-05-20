package com.aescudero.capitole_inditex.application.port.out;

import com.aescudero.capitole_inditex.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {

    Optional<Price> findPrice(Long brandId, Long productId, LocalDateTime applicationDate);
}

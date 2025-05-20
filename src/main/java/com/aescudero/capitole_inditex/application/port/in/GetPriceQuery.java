package com.aescudero.capitole_inditex.application.port.in;

import java.time.LocalDateTime;

public record GetPriceQuery (Long brandId, Long productId, LocalDateTime applicationDate) {
}

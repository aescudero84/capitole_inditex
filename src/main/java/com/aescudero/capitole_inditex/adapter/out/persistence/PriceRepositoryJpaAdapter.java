package com.aescudero.capitole_inditex.adapter.out.persistence;

import com.aescudero.capitole_inditex.adapter.out.persistence.entity.PriceEntity;
import com.aescudero.capitole_inditex.adapter.out.persistence.mapper.PriceMapper;
import com.aescudero.capitole_inditex.adapter.out.persistence.repository.PriceJpaRepository;
import com.aescudero.capitole_inditex.application.port.out.PriceRepository;
import com.aescudero.capitole_inditex.domain.model.Price;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PriceRepositoryJpaAdapter implements PriceRepository {

    private final PriceJpaRepository priceJpaRepository;
    private final PriceMapper priceMapper;

    public PriceRepositoryJpaAdapter(PriceJpaRepository priceJpaRepository, PriceMapper priceMapper) {
        this.priceJpaRepository = priceJpaRepository;
        this.priceMapper = priceMapper;
    }

    @Override
    public Optional<Price> findPrice(Long brandId, Long productId, LocalDateTime applicationDate) {

        Optional<PriceEntity> entity = priceJpaRepository.findByBrandIdAndProductIdAndApplicationDate(
                brandId, productId, applicationDate);

        return entity.map(priceMapper::toDomain);
    }
}

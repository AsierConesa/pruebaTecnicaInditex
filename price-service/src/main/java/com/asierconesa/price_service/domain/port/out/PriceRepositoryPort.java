package com.asierconesa.price_service.domain.port.out;

import com.asierconesa.price_service.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepositoryPort {
    Optional<Price> findPriceByBrandProductAndDate(int brandId, int productId, LocalDateTime applicationDate);
}

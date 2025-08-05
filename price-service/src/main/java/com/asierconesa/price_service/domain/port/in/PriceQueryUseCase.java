package com.asierconesa.price_service.domain.port.in;

import com.asierconesa.price_service.application.dto.PriceResponseDTO;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceQueryUseCase {
    Optional<PriceResponseDTO> findPrice(int brandId, int productId, LocalDateTime applicationDate);
}
package com.asierconesa.price_service.domain.port.in;

import com.asierconesa.price_service.application.dto.PriceCreateRequestDTO;
import com.asierconesa.price_service.application.dto.PriceResponseDTO;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceQueryUseCase {
    Optional<PriceResponseDTO> findPrice(int brandId, int productId, LocalDateTime applicationDate);

    @Transactional
    PriceResponseDTO createPrice(PriceCreateRequestDTO dto);
}
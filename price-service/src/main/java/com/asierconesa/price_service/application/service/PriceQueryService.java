package com.asierconesa.price_service.application.service;

import com.asierconesa.price_service.application.dto.PriceRequestDTO;
import com.asierconesa.price_service.application.dto.PriceResponseDTO;
import com.asierconesa.price_service.application.mapper.PriceDTOMapper;
import com.asierconesa.price_service.domain.model.Price;
import com.asierconesa.price_service.domain.port.in.PriceQueryUseCase;
import com.asierconesa.price_service.domain.port.out.PriceRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceQueryService implements PriceQueryUseCase {

    private final PriceRepositoryPort priceRepositoryPort;
    private final PriceDTOMapper mapper;

    public PriceQueryService(PriceRepositoryPort priceRepositoryPort, PriceDTOMapper mapper) {
        this.priceRepositoryPort = priceRepositoryPort;
        this.mapper = mapper;
    }

    @Override
    public Optional<PriceResponseDTO> findPrice(int brandId, int productId, LocalDateTime applicationDate) {

        Optional<Price> price = priceRepositoryPort.findPriceByBrandProductAndDate(brandId, productId, applicationDate);
        return price.stream().findFirst().map(mapper::toDto);
    }
}
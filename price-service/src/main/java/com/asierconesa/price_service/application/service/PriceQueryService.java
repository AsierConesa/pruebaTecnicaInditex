package com.asierconesa.price_service.application.service;

import com.asierconesa.price_service.application.dto.PriceCreateRequestDTO;
import com.asierconesa.price_service.application.dto.PriceResponseDTO;
import com.asierconesa.price_service.application.mapper.PriceDTOMapper;
import com.asierconesa.price_service.domain.model.Price;
import com.asierconesa.price_service.domain.port.in.PriceQueryUseCase;
import com.asierconesa.price_service.domain.port.out.PriceEventPublisher;
import com.asierconesa.price_service.domain.port.out.PriceRepositoryPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceQueryService implements PriceQueryUseCase {

    private final PriceRepositoryPort priceRepositoryPort;
    private final PriceEventPublisher priceEventPublisher;
    private final PriceDTOMapper mapper;

    public PriceQueryService(PriceRepositoryPort priceRepositoryPort, PriceEventPublisher priceEventPublisher, PriceDTOMapper mapper) {
        this.priceRepositoryPort = priceRepositoryPort;
        this.priceEventPublisher = priceEventPublisher;
        this.mapper = mapper;
    }

    @Override
    public Optional<PriceResponseDTO> findPrice(int brandId, int productId, LocalDateTime applicationDate) {

        Optional<Price> price = priceRepositoryPort.findPriceByBrandProductAndDate(brandId, productId, applicationDate);
        return price.stream().findFirst().map(mapper::toDto);
    }

    @Override
    @Transactional
    public PriceResponseDTO createPrice(PriceCreateRequestDTO dto) {
        Price saved = priceRepositoryPort.save(mapper.toCommand(dto));
        priceEventPublisher.publishPriceCreated(mapper.toEvent(dto));
        return mapper.toDto(saved);
    }
}
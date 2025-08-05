package com.asierconesa.price_service.infraestructure.persistence.repository;

import com.asierconesa.price_service.application.mapper.PriceMOMapper;
import com.asierconesa.price_service.domain.model.Price;
import com.asierconesa.price_service.domain.port.out.PriceRepositoryPort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final JpaPriceRepository repository;
    private final PriceMOMapper mapper;

    public PriceRepositoryAdapter(JpaPriceRepository repository, PriceMOMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Price> findPriceByBrandProductAndDate(int brandId, int productId, LocalDateTime applicationDate) {
        return repository.findMatchingPrices(brandId, productId, applicationDate)
                .stream()
                .findFirst()
                .map(mapper::toDomain);
    }
}
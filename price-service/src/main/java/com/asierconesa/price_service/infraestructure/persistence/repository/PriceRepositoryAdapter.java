package com.asierconesa.price_service.infraestructure.persistence.repository;

import com.asierconesa.price_service.application.command.PriceQueryCommand;
import com.asierconesa.price_service.application.mapper.PriceMOMapper;
import com.asierconesa.price_service.domain.model.Price;
import com.asierconesa.price_service.domain.port.out.PriceRepositoryPort;
import com.asierconesa.price_service.infraestructure.persistence.entity.PriceMO;
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
    public Optional<Price> findPriceByBrandProductAndDate(PriceQueryCommand command) {
        return repository.findMatchingPrices(command.getBrandId(), command.getProductId(), command.getApplicationDate())
                .stream()
                .findFirst()
                .map(mapper::toDomain);
    }
}
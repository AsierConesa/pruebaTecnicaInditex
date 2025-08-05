package com.asierconesa.price_service.domain.port.out;

import com.asierconesa.price_service.application.command.PriceQueryCommand;
import com.asierconesa.price_service.domain.model.Price;

import java.util.Optional;

public interface PriceRepositoryPort {
    Optional<Price> findPriceByBrandProductAndDate(PriceQueryCommand command);
}

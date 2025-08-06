package com.asierconesa.price_service.domain.port.out;

import com.asierconesa.price_service.infraestructure.kafka.dto.PriceCreatedEvent;

public interface PriceEventPublisher {
    void publishPriceCreated(PriceCreatedEvent event);
}
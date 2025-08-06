package com.asierconesa.price_service.infraestructure.kafka.publisher;

import com.asierconesa.price_service.domain.port.out.PriceEventPublisher;
import com.asierconesa.price_service.infraestructure.kafka.dto.PriceCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPriceEventPublisher implements PriceEventPublisher {

    private final KafkaTemplate<String, PriceCreatedEvent> kafkaTemplate;

    public KafkaPriceEventPublisher(KafkaTemplate<String, PriceCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishPriceCreated(PriceCreatedEvent event) {
        kafkaTemplate.send("price-created-topic", event);
    }
}
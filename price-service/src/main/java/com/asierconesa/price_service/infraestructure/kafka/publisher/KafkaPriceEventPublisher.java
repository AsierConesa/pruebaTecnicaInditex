package com.asierconesa.price_service.infraestructure.kafka.publisher;

import com.asierconesa.price_service.domain.model.PriceCreateCommand;
import com.asierconesa.price_service.domain.port.out.PriceEventPublisher;
import com.asierconesa.price_service.infraestructure.kafka.dto.PriceCreatedEvent;
import com.asierconesa.price_service.infraestructure.kafka.mapper.PriceEventMapper;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaPriceEventPublisher implements PriceEventPublisher {

    /**
     * mapper de eventos de kafka.
     */
    private final PriceEventMapper mapperEvent;

    /**
     * Plantilla de kafka especificando el evento que recibe.
     */
    @SuppressFBWarnings("EI_EXPOSE_REP2")
    private final KafkaTemplate<String, PriceCreatedEvent> kafkaTemplate;

    /**
     * publica en kafka el evento recibido.
     * @param command El evento a publicar
     */
    @Override
    public void publishPriceCreated(final PriceCreateCommand command) {
        kafkaTemplate.send("price-created-topic", mapperEvent.toEvent(command));
    }
}

package com.asierconesa.price_service.domain.port.out;

import com.asierconesa.price_service.domain.command.PriceCreateCommand;

public interface PriceEventPublisher {
    /**
     * Crea un mensaje en la cola de mensajería de Kafka
     * una vez el mensaje se ha creado.
     * @param command El evento a publicar
     */
    void publishPriceCreated(PriceCreateCommand command);
}

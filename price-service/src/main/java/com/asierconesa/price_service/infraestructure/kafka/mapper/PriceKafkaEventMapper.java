package com.asierconesa.price_service.infraestructure.kafka.mapper;

import com.asierconesa.price_service.domain.command.PriceCreateCommand;
import com.asierconesa.price_service.infraestructure.kafka.dto.KafkaPriceCreatedMessage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceKafkaEventMapper {

    /**
     * Mapper para mapear de PriceCreateRequestDTO a KafkaPriceCreatedMessage.
     *
     * @param src PriceCreateRequestDTO a mapear
     * @return KafkaPriceCreatedMessage mapeado
     */
    KafkaPriceCreatedMessage toEvent(PriceCreateCommand src);

}

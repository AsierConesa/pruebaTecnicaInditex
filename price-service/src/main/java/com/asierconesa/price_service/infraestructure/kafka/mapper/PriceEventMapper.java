package com.asierconesa.price_service.infraestructure.kafka.mapper;

import com.asierconesa.price_service.domain.model.PriceCreateCommand;
import com.asierconesa.price_service.infraestructure.kafka.dto.PriceCreatedEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceEventMapper {

    /**
     * Mapper para mapear de PriceCreateRequestDTO a PriceCreatedEvent.
     *
     * @param src PriceCreateRequestDTO a mapear
     * @return PriceCreatedEvent mapeado
     */
    PriceCreatedEvent toEvent(PriceCreateCommand src);

}

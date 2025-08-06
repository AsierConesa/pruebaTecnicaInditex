package com.asierconesa.price_service.application.mapper;

import com.asierconesa.price_service.application.dto.PriceCreateRequestDTO;
import com.asierconesa.price_service.application.dto.PriceResponseDTO;
import com.asierconesa.price_service.domain.model.Price;
import com.asierconesa.price_service.domain.model.PriceCreateCommand;
import com.asierconesa.price_service.infraestructure.kafka.dto.PriceCreatedEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceDTOMapper {

    PriceResponseDTO toDto(Price src);

    PriceCreateCommand toCommand(PriceCreateRequestDTO src);

    PriceCreatedEvent toEvent(PriceCreateRequestDTO src);
}
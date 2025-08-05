package com.asierconesa.price_service.application.mapper;

import com.asierconesa.price_service.application.command.PriceQueryCommand;
import com.asierconesa.price_service.application.dto.PriceRequestDTO;
import com.asierconesa.price_service.application.dto.PriceResponseDTO;
import com.asierconesa.price_service.domain.model.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceDTOMapper {

    PriceResponseDTO toDto(Price src);

    PriceQueryCommand toCommand(PriceRequestDTO src);
}
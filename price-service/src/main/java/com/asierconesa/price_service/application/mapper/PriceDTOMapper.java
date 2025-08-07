package com.asierconesa.price_service.application.mapper;

import com.asierconesa.price_service.application.dto.PriceCreateRequestDTO;
import com.asierconesa.price_service.application.dto.PriceResponseDTO;
import com.asierconesa.price_service.domain.model.Price;
import com.asierconesa.price_service.domain.model.PriceCreateCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceDTOMapper {

    /**
     * Mapper para mapear de Price a PriceResponseDTO.
     * @param src Price a mapear
     * @return PriceResponseDTO mapeado
     */
    PriceResponseDTO toDto(Price src);

    /**
     * Mapper para mapear de PriceCreateRequestDTO a PriceCreateCommand.
     * @param src PriceCreateRequestDTO a mapear
     * @return PriceCreateCommand mapeado
     */
    PriceCreateCommand toCommand(PriceCreateRequestDTO src);


}

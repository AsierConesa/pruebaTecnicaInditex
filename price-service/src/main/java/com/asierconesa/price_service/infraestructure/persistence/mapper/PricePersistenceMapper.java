package com.asierconesa.price_service.infraestructure.persistence.mapper;

import com.asierconesa.price_service.domain.model.Price;
import com.asierconesa.price_service.domain.command.PriceCreateCommand;
import com.asierconesa.price_service.infraestructure.persistence.entity.PriceMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricePersistenceMapper {

    /**
     * Mapper para mapear de PriceMO a Price.
     * @param src PriceMO a mapear
     * @return Price mapeado
     */
    Price toDomain(PriceMO src);

    /**
     * Mapper para mapear de PriceCreateCommand a PriceMO.
     * @param src PriceCreateCommand a mapear
     * @return PriceMO mapeado
     */
    PriceMO toMO(PriceCreateCommand src);

}

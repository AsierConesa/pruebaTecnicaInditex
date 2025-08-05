package com.asierconesa.price_service.application.mapper;

import com.asierconesa.price_service.domain.model.Price;
import com.asierconesa.price_service.infraestructure.persistence.entity.PriceMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMOMapper {

    Price toDomain(PriceMO src);

}

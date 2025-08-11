package com.asierconesa.price_service.domain.port.out;

import com.asierconesa.price_service.domain.model.Price;
import com.asierconesa.price_service.domain.command.PriceCreateCommand;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepositoryPort {

    /**
     * Encuentra un objeto Price con los parámetros datos y
     * la prioridad mayor.
     * @param brandId ID de la marca
     * @param productId ID del producto
     * @param applicationDate Fecha de la aplicación
     * @return devuelve un Optional del Price recogido
     */
    Optional<Price> findPriceByBrandProductAndDate(
            int brandId,
            int productId,
            LocalDateTime applicationDate);

    /**
     * Crea un Price en BBDD dado un PriceCreateCommand.
     * @param command el Price a crear
     * @return devuelve el Price creado
     */
    Price save(PriceCreateCommand command);
}

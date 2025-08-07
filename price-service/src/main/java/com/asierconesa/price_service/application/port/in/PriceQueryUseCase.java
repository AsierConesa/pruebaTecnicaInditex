package com.asierconesa.price_service.application.port.in;

import com.asierconesa.price_service.application.dto.PriceCreateRequestDTO;
import com.asierconesa.price_service.application.dto.PriceResponseDTO;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceQueryUseCase {
    /**
     * Encuentra un Price en BBDD con los parámetros dados.
     * @param brandId ID de la marca
     * @param productId ID del producto
     * @param applicationDate Fecha de aplicación
     * @return devuelve un Optional del DTO del precio encontrado
     */
    Optional<PriceResponseDTO> findPrice(
            int brandId,
            int productId,
            LocalDateTime applicationDate);

    /**
     * Crea un objeto en base a un PriceCreateRequestDTO.
     * @param dto el DTO del objeto a crear
     * @return devuelve el DTO del objeto creado
     */
    @Transactional
    PriceResponseDTO createPrice(PriceCreateRequestDTO dto);
}

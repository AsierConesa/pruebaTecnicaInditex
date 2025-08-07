package com.asierconesa.price_service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceResponseDTO {

    /**
     * ID del producto al que pertenece el precio.
     */
    private int productId;

    /**
     * ID de la marca.
     */
    private int brandId;

    /**
     * Lista de precios (price list) que aplica.
     */
    private int priceList;

    /**
     * Fecha de inicio de la validez del precio.
     */
    private LocalDateTime startDate;

    /**
     * Fecha de fin de la validez del precio.
     */
    private LocalDateTime endDate;

    /**
     * Valor del precio.
     */
    private BigDecimal price;

    /**
     * Moneda del precio (EUR, USD...).
     */
    private String currency;
}

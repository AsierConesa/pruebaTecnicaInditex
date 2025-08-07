package com.asierconesa.price_service.infraestructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceMO {

    /**
     * ID autogenerado de la BBDD.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ID de la marca.
     */
    @Column(name = "brand_id", nullable = false)
    private int brandId;

    /**
     * Fecha de inicio de la validez del precio.
     */
    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    /**
     * Fecha de fin de la validez del precio.
     */
    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    /**
     * Lista de precios (price list) que aplica.
     */
    @Column(name = "price_list", nullable = false)
    private int priceList;

    /**
     * ID del producto al que pertenece el precio.
     */
    @Column(name = "product_id", nullable = false)
    private int productId;

    /**
     * Prioridad del precio frente a otros posibles.
     */
    @Column(name = "priority", nullable = false)
    private int priority;

    /**
     * Valor del precio.
     */
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    /**
     * Moneda del precio (EUR, USD...).
     */
    @Column(name = "curr", length = 3, nullable = false)
    private String currency;

}

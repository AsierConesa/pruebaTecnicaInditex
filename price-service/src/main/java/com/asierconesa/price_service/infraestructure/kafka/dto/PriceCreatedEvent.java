package com.asierconesa.price_service.infraestructure.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceCreatedEvent {
    private int productId;
    private int brandId;
    private int priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priority;
    private BigDecimal price;
    private String currency;
}

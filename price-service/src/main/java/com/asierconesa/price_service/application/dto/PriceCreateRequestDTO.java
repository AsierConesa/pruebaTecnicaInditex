package com.asierconesa.price_service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceCreateRequestDTO {

    private int productId;
    private int brandId;
    private int priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priority;
    private BigDecimal price;
    private String currency;

}
package com.asierconesa.price_service.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceQueryCommand {
    private int brandId;
    private int productId;
    private LocalDateTime applicationDate;
}
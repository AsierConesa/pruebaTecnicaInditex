package com.asierconesa.price_service.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {

     private Integer productId;
     private Integer brandId;
     private Integer priceList;
     private LocalDateTime startDate;
     private LocalDateTime endDate;
     private Integer priority;
     private BigDecimal price;
     private String currency;

}
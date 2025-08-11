package com.asierconesa.price_service.infraestructure.persistence.mapper;

import com.asierconesa.price_service.domain.model.Price;
import com.asierconesa.price_service.domain.command.PriceCreateCommand;
import com.asierconesa.price_service.infraestructure.persistence.entity.PriceMO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PricePersistenceMapperTest {

    private final PricePersistenceMapper mapper = Mappers.getMapper(PricePersistenceMapper.class);

    @Test
    void testToDomain() {
        PriceMO priceMO = new PriceMO();
        priceMO.setId(1L);
        priceMO.setProductId(35455);
        priceMO.setBrandId(1);
        priceMO.setPriceList(2);
        priceMO.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
        priceMO.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59));
        priceMO.setPrice(BigDecimal.valueOf(35.50));
        priceMO.setCurrency("EUR");
        priceMO.setPriority(1);

        Price price = mapper.toDomain(priceMO);

        assertNotNull(price);
        assertEquals(priceMO.getProductId(), price.getProductId());
        assertEquals(priceMO.getBrandId(), price.getBrandId());
        assertEquals(priceMO.getPriceList(), price.getPriceList());
        assertEquals(priceMO.getStartDate(), price.getStartDate());
        assertEquals(priceMO.getEndDate(), price.getEndDate());
        assertEquals(priceMO.getPrice(), price.getPrice());
        assertEquals(priceMO.getCurrency(), price.getCurrency());
    }

    @Test
    void testToMO() {
        PriceCreateCommand command = new PriceCreateCommand();
        command.setProductId(35455);
        command.setBrandId(1);
        command.setPriceList(2);
        command.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
        command.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59));
        command.setPrice(BigDecimal.valueOf(50.00));
        command.setCurrency("EUR");
        command.setPriority(1);

        PriceMO priceMO = mapper.toMO(command);

        assertNotNull(priceMO);
        assertEquals(command.getProductId(), priceMO.getProductId());
        assertEquals(command.getBrandId(), priceMO.getBrandId());
        assertEquals(command.getPriceList(), priceMO.getPriceList());
        assertEquals(command.getStartDate(), priceMO.getStartDate());
        assertEquals(command.getEndDate(), priceMO.getEndDate());
        assertEquals(command.getPrice(), priceMO.getPrice());
        assertEquals(command.getCurrency(), priceMO.getCurrency());
        assertEquals(command.getPriority(), priceMO.getPriority());
    }
}
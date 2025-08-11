package com.asierconesa.price_service.infraestructure.kafka.mapper;

import com.asierconesa.price_service.domain.command.PriceCreateCommand;
import com.asierconesa.price_service.infraestructure.kafka.dto.KafkaPriceCreatedMessage;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PriceKafkaEventMapperTest {

    private final PriceKafkaEventMapper mapper = Mappers.getMapper(PriceKafkaEventMapper.class);

    @Test
    void testToEvent() {
        PriceCreateCommand command = new PriceCreateCommand();
        command.setProductId(35455);
        command.setBrandId(1);
        command.setPriceList(2);
        command.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
        command.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59));
        command.setPrice(BigDecimal.valueOf(50.00));
        command.setCurrency("EUR");
        command.setPriority(1);

        KafkaPriceCreatedMessage event = mapper.toEvent(command);

        assertNotNull(event);
        assertEquals(command.getProductId(), event.getProductId());
        assertEquals(command.getBrandId(), event.getBrandId());
        assertEquals(command.getPriceList(), event.getPriceList());
        assertEquals(command.getStartDate(), event.getStartDate());
        assertEquals(command.getEndDate(), event.getEndDate());
        assertEquals(command.getPrice(), event.getPrice());
        assertEquals(command.getCurrency(), event.getCurrency());
        assertEquals(command.getPriority(), event.getPriority());
    }
}

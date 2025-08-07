package com.asierconesa.price_service.application.mapper;

import com.asierconesa.price_service.application.dto.PriceCreateRequestDTO;
import com.asierconesa.price_service.application.dto.PriceResponseDTO;
import com.asierconesa.price_service.domain.model.Price;
import com.asierconesa.price_service.domain.model.PriceCreateCommand;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PriceDTOMapperTest {

    private final PriceDTOMapper mapper = Mappers.getMapper(PriceDTOMapper.class);

    @Test
    void testToDto() {
        Price price = new Price();
        price.setProductId(35455);
        price.setBrandId(1);
        price.setPriceList(2);
        price.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
        price.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59));
        price.setPrice(BigDecimal.valueOf(35.50));
        price.setCurrency("EUR");

        PriceResponseDTO dto = mapper.toDto(price);

        assertNotNull(dto);
        assertEquals(price.getProductId(), dto.getProductId());
        assertEquals(price.getBrandId(), dto.getBrandId());
        assertEquals(price.getPriceList(), dto.getPriceList());
        assertEquals(price.getStartDate(), dto.getStartDate());
        assertEquals(price.getEndDate(), dto.getEndDate());
        assertEquals(price.getPrice(), dto.getPrice());
        assertEquals(price.getCurrency(), dto.getCurrency());
    }

    @Test
    void testToCommand() {
        PriceCreateRequestDTO requestDTO = new PriceCreateRequestDTO();
        requestDTO.setProductId(35455);
        requestDTO.setBrandId(1);
        requestDTO.setPriceList(2);
        requestDTO.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
        requestDTO.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59));
        requestDTO.setPrice(BigDecimal.valueOf(50.00));
        requestDTO.setCurrency("EUR");
        requestDTO.setPriority(1);

        PriceCreateCommand command = mapper.toCommand(requestDTO);

        assertNotNull(command);
        assertEquals(requestDTO.getProductId(), command.getProductId());
        assertEquals(requestDTO.getBrandId(), command.getBrandId());
        assertEquals(requestDTO.getPriceList(), command.getPriceList());
        assertEquals(requestDTO.getStartDate(), command.getStartDate());
        assertEquals(requestDTO.getEndDate(), command.getEndDate());
        assertEquals(requestDTO.getPrice(), command.getPrice());
        assertEquals(requestDTO.getCurrency(), command.getCurrency());
        assertEquals(requestDTO.getPriority(), command.getPriority());
    }
}
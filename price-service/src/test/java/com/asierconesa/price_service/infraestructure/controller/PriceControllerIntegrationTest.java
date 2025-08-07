package com.asierconesa.price_service.infraestructure.controller;

import com.asierconesa.price_service.application.dto.PriceCreateRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String BASE_URL = "/prices";

    private PriceCreateRequestDTO createValidPriceDTO() {
        PriceCreateRequestDTO dto = new PriceCreateRequestDTO();
        dto.setBrandId(1);
        dto.setProductId(35455);
        dto.setPriceList(5);
        dto.setStartDate(LocalDateTime.of(2020, 6, 17, 10, 0));
        dto.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59));
        dto.setPrice(new BigDecimal("44.95"));
        dto.setPriority(2);
        dto.setCurrency("EUR");
        return dto;
    }

    @Test
    void testPriceAt_2020_06_14_10_00() throws Exception {
        mockMvc.perform(get(BASE_URL)
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14T10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    void testPriceAt_2020_06_14_16_00() throws Exception {
        mockMvc.perform(get(BASE_URL)
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14T16:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.price").value(25.45));
    }

    @Test
    void testPriceAt_2020_06_14_21_00() throws Exception {
        mockMvc.perform(get(BASE_URL)
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14T21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    void testPriceAt_2020_06_15_10_00() throws Exception {
        mockMvc.perform(get(BASE_URL)
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-15T10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.price").value(30.50));
    }

    @Test
    void testPriceAt_2020_06_16_21_00() throws Exception {
        mockMvc.perform(get(BASE_URL)
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-16T21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.price").value(38.95));
    }

    @Test
    void testCreatePrice() throws Exception {
        PriceCreateRequestDTO priceDTO = createValidPriceDTO();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // <- AÑADIDO
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Opcional, para un formato más legible

        mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(priceDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.productId").value(priceDTO.getProductId()))
                .andExpect(jsonPath("$.brandId").value(priceDTO.getBrandId()))
                .andExpect(jsonPath("$.priceList").value(priceDTO.getPriceList()))
                .andExpect(jsonPath("$.price").value(priceDTO.getPrice()));
    }
}
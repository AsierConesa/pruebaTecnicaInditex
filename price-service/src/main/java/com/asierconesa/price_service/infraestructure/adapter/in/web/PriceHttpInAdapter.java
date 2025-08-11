package com.asierconesa.price_service.infraestructure.adapter.in.web;

import com.asierconesa.price_service.application.dto.PriceCreateRequestDTO;
import com.asierconesa.price_service.application.dto.PriceResponseDTO;
import com.asierconesa.price_service.application.service.PriceQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/prices")
public class PriceHttpInAdapter {

    /**
     * El servicio.
     */
    private final PriceQueryService priceQueryService;

    /**
     * Metodo GET para obtener un Price con los parámetros dados.
     * @param brandId ID de marca
     * @param productId ID de producto
     * @param applicationDate Fecha de aplicación
     * @return respuesta con codigo HTTP y con el Price si la respuesta es OK
     */
    @GetMapping
    public ResponseEntity<PriceResponseDTO> getPrice(
            @RequestParam final int brandId,
            @RequestParam final int productId,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            final LocalDateTime applicationDate) {

        return priceQueryService
                .findPrice(brandId, productId, applicationDate)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Peticion POST para la creacion de un Price dado un body.
     * @param request el Price a crear
     * @return El código HTTP de la petición con el dto
     * si se ha creado correctamente
     */
    @PostMapping
    public ResponseEntity<PriceResponseDTO> createPrice(
            @RequestBody final PriceCreateRequestDTO request) {
        PriceResponseDTO response = priceQueryService.createPrice(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

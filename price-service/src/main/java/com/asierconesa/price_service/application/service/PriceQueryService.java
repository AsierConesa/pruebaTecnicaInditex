package com.asierconesa.price_service.application.service;

import com.asierconesa.price_service.application.dto.PriceCreateRequestDTO;
import com.asierconesa.price_service.application.dto.PriceResponseDTO;
import com.asierconesa.price_service.application.mapper.PriceDTOMapper;
import com.asierconesa.price_service.domain.model.Price;
import com.asierconesa.price_service.application.port.in.PriceQueryUseCase;
import com.asierconesa.price_service.domain.port.out.PriceEventPublisher;
import com.asierconesa.price_service.domain.port.out.PriceRepositoryPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriceQueryService implements PriceQueryUseCase {

    /**
     * El puerto del Repositorio.
     */
    private final PriceRepositoryPort priceRepositoryPort;

    /**
     * El publisher de kafka.
     */
    private final PriceEventPublisher priceEventPublisher;

    /**
     * El mapper de objetos con la capa de DTO.
     */
    private final PriceDTOMapper mapperDTO;

    /**
     * Metodo de servicio para sacar el Price de BBDD dados.
     * su brandId, productId y applicationDate con mayor prioridad.
     * @param brandId ID de la marca
     * @param productId ID del producto
     * @param applicationDate Fecha de aplicación
     * @return devuelve el Optional de PriceResponseDTO encontrado
     */
    @Override
    public Optional<PriceResponseDTO> findPrice(
            final int brandId,
            final int productId,
            final LocalDateTime applicationDate) {

        Optional<Price> price = priceRepositoryPort
                .findPriceByBrandProductAndDate(
                        brandId,
                        productId,
                        applicationDate);
        return price.stream().findFirst().map(mapperDTO::toDto);
    }

    /**
     * Metodo de servicio para crear un Price y publicarlo en kafka,
     * dado un PriceCreateRequestDTO.
     * @param dto entidad DTO con los datos necesarios para creación
     * @return devuelve el PriceResponseDTO creado
     */
    @Override
    @Transactional
    public PriceResponseDTO createPrice(final PriceCreateRequestDTO dto) {
        var command = mapperDTO.toCommand(dto);
        Price saved = priceRepositoryPort.save(command);
        priceEventPublisher.publishPriceCreated(command);
        return mapperDTO.toDto(saved);
    }
}

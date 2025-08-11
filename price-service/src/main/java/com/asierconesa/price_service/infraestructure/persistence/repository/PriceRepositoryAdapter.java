package com.asierconesa.price_service.infraestructure.persistence.repository;

import com.asierconesa.price_service.infraestructure.persistence.mapper.PricePersistenceMapper;
import com.asierconesa.price_service.domain.model.Price;
import com.asierconesa.price_service.domain.command.PriceCreateCommand;
import com.asierconesa.price_service.domain.port.out.PriceRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    /**
     * El repositorio JPA.
     */
    private final JpaPriceRepository repository;

    /**
     * El mapper Mapstruct.
     */
    private final PricePersistenceMapper mapper;

    /**
     * Busca el Price en el repositorio con los parametros dados
     * cuyo priority sea mayor.
     * @param brandId ID de la marca
     * @param productId ID del producto
     * @param applicationDate Fecha de la aplicación
     * @return devuelve un Optional del Price solicitado
     */
    @Override
    public Optional<Price> findPriceByBrandProductAndDate(
            final int brandId,
            final int productId,
            final LocalDateTime applicationDate) {
        return repository.findTopByBrandIdProductIdAndApplicationDate(
                brandId, productId, applicationDate)
                .map(mapper::toDomain);
    }

    /**
     * Guarda un Price en BBDD.
     * @param command el Price a crear
     * @return el Price Creado
     */
    @Override
    public Price save(final PriceCreateCommand command) {
        return mapper.toDomain(repository.save(mapper.toMO(command)));
    }
}

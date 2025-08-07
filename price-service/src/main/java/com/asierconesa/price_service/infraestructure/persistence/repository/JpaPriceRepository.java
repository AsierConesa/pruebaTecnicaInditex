package com.asierconesa.price_service.infraestructure.persistence.repository;

import com.asierconesa.price_service.infraestructure.persistence.entity.PriceMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface JpaPriceRepository extends JpaRepository<PriceMO, Long> {

    /**
     * Consulta de repositorio para sacar el Price de BBDD.
     * @param brandId ID de marca
     * @param productId ID de producto
     * @param applicationDate Fecha de aplicación
     * @return Optional del PriceMO solicitado
     */
    @Query(value = "SELECT * FROM prices p " +
            "WHERE p.brand_id = :brandId " +
            "AND p.product_id = :productId " +
            "AND :applicationDate BETWEEN p.start_date AND p.end_date " +
            "ORDER BY p.priority DESC " +
            "LIMIT 1",
            nativeQuery = true)
    Optional<PriceMO> findTopByBrandIdProductIdAndApplicationDate(
            int brandId,
            int productId,
            LocalDateTime applicationDate);

}

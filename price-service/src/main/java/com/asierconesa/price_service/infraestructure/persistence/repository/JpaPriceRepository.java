package com.asierconesa.price_service.infraestructure.persistence.repository;

import com.asierconesa.price_service.infraestructure.persistence.entity.PriceMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface JpaPriceRepository extends JpaRepository<PriceMO, Long> {
    @Query("""
           SELECT p FROM PriceMO p
           WHERE p.brandId = :brandId
             AND p.productId = :productId
             AND :applicationDate BETWEEN p.startDate AND p.endDate
           ORDER BY p.priority DESC
           """)
    List<PriceMO> findMatchingPrices(int brandId, int productId, LocalDateTime applicationDate);

}

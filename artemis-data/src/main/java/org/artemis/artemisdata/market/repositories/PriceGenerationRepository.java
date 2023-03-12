package org.artemis.artemisdata.market.repositories;

import org.artemis.artemisdata.market.entities.PriceGenerationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceGenerationRepository extends JpaRepository<PriceGenerationEntity, Long> {
    List<PriceGenerationEntity> findAllBySymbolOOrderByDateDesc(String symbol);
}

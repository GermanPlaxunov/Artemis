package org.artemis.artemisdata.market.service.interfaces;

import org.artemis.artemisdata.market.entities.PriceGenerationEntity;

import java.util.List;

public interface PriceGenerationService {
    void save(PriceGenerationEntity entity);

    void saveAll(List<PriceGenerationEntity> entities);

    List<PriceGenerationEntity> findAll();

    List<PriceGenerationEntity> findAllBySymbol(String symbol);

    void delete(PriceGenerationEntity entity);
}

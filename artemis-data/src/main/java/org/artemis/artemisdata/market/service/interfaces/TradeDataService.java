package org.artemis.artemisdata.market.service.interfaces;

import org.artemis.artemisdata.market.entities.TradeDataEntity;

import java.util.List;

public interface TradeDataService {
    void save(TradeDataEntity entity);

    void saveAll(List<TradeDataEntity> entities);

    List<TradeDataEntity> findAllBySymbol(String symbol);

    void deleteById(Long id);

    void deleteByIds(List<Long> ids);
}

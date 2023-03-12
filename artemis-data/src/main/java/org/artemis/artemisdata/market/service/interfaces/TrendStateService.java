package org.artemis.artemisdata.market.service.interfaces;

import org.artemis.artemisdata.market.entities.TrendStateEntity;

import java.util.List;

public interface TrendStateService {
    List<TrendStateEntity> findAll();

    TrendStateEntity findBySymbol(String symbol);

    void updateShortTrendTime(String symbol);

    void updateLongTrendTime(String symbol);

    void deleteBySymbol(String symbol);
}

package org.artemis.artemisdata.polygon.service.interfaces;

public interface IndicatorService {
    Double getSmaValue(String symbol);

    Double getEmaValue(String symbol);

    Double getMacdValue(String symbol);

    Double getRsiValue(String symbol);

    void saveSma(String symbol, Double value);

    void saveEma(String symbol, Double value);

    void saveMacd(String symbol, Double value);

    void saveRsi(String symbol, Double value);
}
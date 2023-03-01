package org.artemis.artemisdata.polygon.service.impl;

import lombok.RequiredArgsConstructor;
import org.artemis.artemiscommon.polygon.IndicatorType;
import org.artemis.artemisdata.polygon.entities.IndicatorEntity;
import org.artemis.artemisdata.polygon.repository.IndicatorRepository;
import org.artemis.artemisdata.polygon.service.interfaces.IndicatorService;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class IndicatorServiceImpl implements IndicatorService {
    private final IndicatorRepository repository;

    @Override
    public Double getSmaValue(String symbol) {
        var name = IndicatorType.INDICATOR_TYPE_SMA.name();
        return getVal(repository.findByNameAndSymbol(name, symbol));
    }

    @Override
    public Double getEmaValue(String symbol) {
        var name = IndicatorType.INDICATOR_TYPE_EMA.name();
        return getVal(repository.findByNameAndSymbol(name, symbol));
    }

    @Override
    public Double getMacdValue(String symbol) {
        var name = IndicatorType.INDICATOR_TYPE_MACD.name();
        return getVal(repository.findByNameAndSymbol(name, symbol));
    }

    @Override
    public Double getRsiValue(String symbol) {
        var name = IndicatorType.INDICATOR_TYPE_RSI.name();
        return getVal(repository.findByNameAndSymbol(name, symbol));
    }

    @Override
    public void saveSma(String symbol, Double value) {
        var name = IndicatorType.INDICATOR_TYPE_SMA.name();
        repository.saveAndFlush(createEntity(name, symbol, value));
    }

    @Override
    public void saveEma(String symbol, Double value) {
        var name = IndicatorType.INDICATOR_TYPE_EMA.name();
        repository.saveAndFlush(createEntity(name, symbol, value));
    }

    @Override
    public void saveMacd(String symbol, Double value) {
        var name = IndicatorType.INDICATOR_TYPE_SMA.name();
        repository.saveAndFlush(createEntity(name, symbol, value));
    }

    @Override
    public void saveRsi(String symbol, Double value) {
        var name = IndicatorType.INDICATOR_TYPE_RSI.name();
        repository.saveAndFlush(createEntity(name, symbol, value));
    }

    private IndicatorEntity createEntity(String name, String symbol, Double value) {
        return new IndicatorEntity()
                .setName(name)
                .setSymbol(symbol)
                .setValue(value)
                .setDate(LocalDateTime.now());
    }

    private Double getVal(Optional<IndicatorEntity> optional) {
        return optional
                .filter(Objects::nonNull)
                .map(IndicatorEntity::getValue)
                .orElse(null);
    }
}
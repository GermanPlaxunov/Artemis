package org.artemis.artemisdata.market.service.classes;

import lombok.RequiredArgsConstructor;
import org.artemis.artemisdata.market.entities.TrendStateEntity;
import org.artemis.artemisdata.market.repositories.TrendStateRepository;
import org.artemis.artemisdata.market.service.interfaces.TrendStateService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class TrendStateServiceImpl implements TrendStateService {

    private final TrendStateRepository repository;

    @Override
    public List<TrendStateEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public TrendStateEntity findBySymbol(String symbol) {
        return repository.findBySymbol(symbol)
                .filter(Objects::nonNull)
                .orElse(null);
    }

    @Override
    public void updateShortTrendTime(String symbol) {
        repository.updateShortTrendChangeTime(symbol, LocalDateTime.now());
    }

    @Override
    public void updateLongTrendTime(String symbol) {
        repository.updateLongTrendChangeTime(symbol, LocalDateTime.now());
    }

    @Override
    public void deleteBySymbol(String symbol) {
        repository.deleteAllBySymbol(symbol);
    }
}

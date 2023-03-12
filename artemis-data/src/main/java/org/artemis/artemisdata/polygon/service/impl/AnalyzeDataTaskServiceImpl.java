package org.artemis.artemisdata.polygon.service.impl;

import lombok.RequiredArgsConstructor;
import org.artemis.artemisdata.polygon.entities.AnalyzeDataTaskEntity;
import org.artemis.artemisdata.polygon.repository.AnalyzeDataTaskRepository;
import org.artemis.artemisdata.polygon.service.interfaces.AnalyzeDataTaskService;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class AnalyzeDataTaskServiceImpl implements AnalyzeDataTaskService {
    private final AnalyzeDataTaskRepository repository;

    @Override
    public AnalyzeDataTaskEntity findBySymbol(String symbol) {
        return repository.findBySymbol(symbol)
                .filter(Objects::nonNull)
                .orElse(null);
    }

    @Override
    public List<AnalyzeDataTaskEntity> findAllEnabledTasks() {
        return repository.findAllByEnabled(true);
    }

    @Override
    public void save(AnalyzeDataTaskEntity entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public void disableBySymbol(String symbol) {
        repository.toggleBySymbol(symbol, false);
    }

    @Override
    public void enableBySymbol(String symbol) {
        repository.toggleBySymbol(symbol, true);
    }
}

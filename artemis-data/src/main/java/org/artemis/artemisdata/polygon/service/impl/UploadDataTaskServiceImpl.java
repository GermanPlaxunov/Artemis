package org.artemis.artemisdata.polygon.service.impl;

import lombok.RequiredArgsConstructor;
import org.artemis.artemisdata.polygon.entities.UploadDataTaskEntity;
import org.artemis.artemisdata.polygon.repository.UploadDataTaskRepository;
import org.artemis.artemisdata.polygon.service.interfaces.UploadDataTaskService;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class UploadDataTaskServiceImpl implements UploadDataTaskService {

    private final UploadDataTaskRepository repository;

    @Override
    public UploadDataTaskEntity findBySymbol(String symbol) {
        return repository.findBySymbolAndIsEnabled(symbol, true)
                .filter(Objects::nonNull)
                .orElse(null);
    }

    @Override
    public List<UploadDataTaskEntity> findAllEnabledTasks() {
        return repository.findAllByIsEnabled(true);
    }

    @Override
    public void save(UploadDataTaskEntity entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public void disableBySymbol(String symbol) {
        repository.toggleTask(symbol, false);
    }

    @Override
    public void enableBySymbol(String symbol) {
        repository.toggleTask(symbol, true);
    }
}

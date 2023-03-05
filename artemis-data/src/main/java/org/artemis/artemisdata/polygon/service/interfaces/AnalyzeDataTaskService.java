package org.artemis.artemisdata.polygon.service.interfaces;

import org.artemis.artemisdata.polygon.entities.AnalyzeDataTaskEntity;

import java.util.List;

public interface AnalyzeDataTaskService {

    AnalyzeDataTaskEntity findBySymbol(String symbol);
    List<AnalyzeDataTaskEntity> findAllEnabledTasks();

    void save(AnalyzeDataTaskEntity entity);

    void disableBySymbol(String symbol);

    void enableBySymbol(String symbol);
}
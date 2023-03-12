package org.artemis.artemisdata.polygon.service.interfaces;

import org.artemis.artemisdata.polygon.entities.UploadDataTaskEntity;

import java.util.List;

public interface UploadDataTaskService {

    UploadDataTaskEntity findBySymbol(String symbol);
    List<UploadDataTaskEntity> findAllEnabledTasks();

    void save(UploadDataTaskEntity entity);

    void disableBySymbol(String symbol);

    void enableBySymbol(String symbol);
}
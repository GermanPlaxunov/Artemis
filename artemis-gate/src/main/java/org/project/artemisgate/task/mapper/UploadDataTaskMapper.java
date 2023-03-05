package org.project.artemisgate.task.mapper;

import org.artemis.artemisdata.polygon.entities.UploadDataTaskEntity;
import org.artemis.artemismodel.task.UploadDataTask;

public class UploadDataTaskMapper {

    public UploadDataTask map(UploadDataTaskEntity entity) {
        return new UploadDataTask()
                .setSymbol(entity.getSymbol())
                .setDataInterval(entity.getDataInterval())
                .setTaskInterval(entity.getTaskInterval());
    }
}
package org.project.artemisgate.task.mapper;

import org.artemis.artemisdata.polygon.entities.AnalyzeDataTaskEntity;
import org.artemis.artemismodel.task.AnalyzeDataTask;

public class AnalyzeDataTaskMapper {

  public AnalyzeDataTask map(AnalyzeDataTaskEntity entity){
    return new AnalyzeDataTask()
            .setSymbol(entity.getSymbol());
  }
}
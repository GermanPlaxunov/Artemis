package org.project.artemisgate.client;

import org.artemis.artemismodel.task.AnalyzeDataTask;
import org.artemis.artemismodel.task.UploadDataTask;

public interface CoreClient {

    void processDataTask(UploadDataTask uploadDataTask);
    void processAnalyzeTask(AnalyzeDataTask analyzeDataTask);
}

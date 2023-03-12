package org.project.artemiscore.rest;

import org.artemis.artemismodel.task.AnalyzeDataTask;
import org.artemis.artemismodel.task.UploadDataTask;

public interface CoreController {

    void processDataTask(UploadDataTask uploadDataTask);

    void processAnalyzeTask(AnalyzeDataTask analyzeDataTask);
}

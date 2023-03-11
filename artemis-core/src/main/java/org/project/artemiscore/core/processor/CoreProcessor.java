package org.project.artemiscore.core.processor;

import lombok.RequiredArgsConstructor;
import org.artemis.artemismodel.task.AnalyzeDataTask;
import org.artemis.artemismodel.task.UploadDataTask;
import org.project.artemiscore.client.PolygonClient;

@RequiredArgsConstructor
public class CoreProcessor {
    private final PolygonClient polygonClient;

    public void processDataTask(UploadDataTask task) {

        throw new UnsupportedOperationException("Not done yet");
    }

    public void processAnalyzeTask(AnalyzeDataTask task) {
        throw new UnsupportedOperationException("Not done yet");
    }
}
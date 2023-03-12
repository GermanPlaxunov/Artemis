package org.project.artemiscore.core.processor;

import lombok.RequiredArgsConstructor;
import org.artemis.artemismodel.task.AnalyzeDataTask;
import org.artemis.artemismodel.task.UploadDataTask;
import org.project.artemiscore.client.PolygonClient;
import org.project.artemiscore.core.builder.PolygonRequestBuilder;

@RequiredArgsConstructor
public class CoreProcessor {
    private final PolygonRequestBuilder polygonRequestBuilder;
    private final PolygonClient polygonClient;

    public void processDataTask(UploadDataTask task) {
        var request = polygonRequestBuilder.createPolygonRequest(task);
        polygonClient.requestPolygonData(request);
    }

    public void processAnalyzeTask(AnalyzeDataTask task) {
        var request = polygonRequestBuilder.createPolygonRequest(task);
        polygonClient.requestPolygonData(request);
    }
}
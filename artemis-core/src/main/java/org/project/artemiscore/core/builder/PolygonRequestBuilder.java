package org.project.artemiscore.core.builder;

import org.artemis.artemismodel.polygon.PolygonDataRequest;
import org.artemis.artemismodel.polygon.PolygonIndicatorRequest;
import org.artemis.artemismodel.polygon.PolygonRequest;
import org.artemis.artemismodel.task.AnalyzeDataTask;
import org.artemis.artemismodel.task.UploadDataTask;

import java.time.LocalDateTime;

public class PolygonRequestBuilder {

    public PolygonRequest createPolygonRequest(UploadDataTask task) {
        return new PolygonRequest()
                .setDataRequest(createDataRequest(task));
    }

    public PolygonRequest createPolygonRequest(AnalyzeDataTask task) {
        return new PolygonRequest()
                .setIndicatorRequest(createIndicatorRequest(task));
    }

    private PolygonDataRequest createDataRequest(UploadDataTask task) {
        return new PolygonDataRequest()
                .setRequestType(task.getEntity())
                .setStockTicker(task.getSymbol());
    }

    private PolygonIndicatorRequest createIndicatorRequest(AnalyzeDataTask task) {
        return new PolygonIndicatorRequest()
                .setSymbol(task.getSymbol())
                .setIndicatorName(task.getIndicatorName())
                .setTimespan("day")
                .setTimestamp(LocalDateTime.now());
    }

}

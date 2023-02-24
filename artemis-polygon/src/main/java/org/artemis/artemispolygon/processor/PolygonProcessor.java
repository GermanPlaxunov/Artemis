package org.artemis.artemispolygon.processor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.artemis.artemismodel.polygon.PolygonDataRequest;
import org.artemis.artemismodel.polygon.PolygonIndicatorRequest;
import org.artemis.artemispolygon.client.PolygonClient;

@Slf4j
@RequiredArgsConstructor
public class PolygonProcessor {

    private final PolygonClient polygonClient;

    public void processDataRequest(PolygonDataRequest request) {

    }

    public void processIndicatorRequest(PolygonIndicatorRequest request) {

    }
}
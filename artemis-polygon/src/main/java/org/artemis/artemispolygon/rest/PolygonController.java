package org.artemis.artemispolygon.rest;

import lombok.RequiredArgsConstructor;
import org.artemis.artemiscommon.polygon.PolygonEndpoint;
import org.artemis.artemiscommon.utils.Utils;
import org.artemis.artemismodel.polygon.PolygonDataRequest;
import org.artemis.artemismodel.polygon.PolygonRequest;
import org.artemis.artemispolygon.processor.PolygonProcessor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PolygonController {

    private final PolygonProcessor processor;

    @PostMapping(path = "/requestPolygonData")
    public void requestPolygonData(PolygonRequest request) {
        var code = request.getRequestType();
        if (isDataRequest(code)) {
            processor.processDataRequest(request.getDataRequest());
        } else {
            processor.processIndicatorRequest(request.getIndicatorRequest());
        }
    }

    private boolean isDataRequest(String code) {
        return PolygonEndpoint.isDataCode(code);
    }
}
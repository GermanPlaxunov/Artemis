package org.artemis.artemispolygon.rest;

import lombok.RequiredArgsConstructor;
import org.artemis.artemiscommon.polygon.PolygonEndpoint;
import org.artemis.artemismodel.polygon.PolygonRequest;
import org.artemis.artemispolygon.processor.PolygonProcessor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

@RestController
@RequiredArgsConstructor
public class PolygonController {

    private final PolygonProcessor processor;

    @PostMapping(path = "/requestPolygonData",
            consumes = MediaType.APPLICATION_JSON_VALUE + WebUtils.CONTENT_TYPE_CHARSET_PREFIX + "UTF-8",
            produces = MediaType.APPLICATION_JSON_VALUE + WebUtils.CONTENT_TYPE_CHARSET_PREFIX + "UTF-8")
    public void requestPolygonData(@RequestBody PolygonRequest request) {
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
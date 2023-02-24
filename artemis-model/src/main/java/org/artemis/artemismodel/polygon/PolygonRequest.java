package org.artemis.artemismodel.polygon;

import lombok.Data;

@Data
public class PolygonRequest {
    private String requestType;
    private PolygonDataRequest dataRequest;
    private PolygonIndicatorRequest indicatorRequest;
}

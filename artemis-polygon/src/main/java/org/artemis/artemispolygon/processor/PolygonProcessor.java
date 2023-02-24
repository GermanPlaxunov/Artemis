package org.artemis.artemispolygon.processor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.artemis.artemiscommon.polygon.PolygonEndpoint;
import org.artemis.artemismodel.polygon.PolygonDataRequest;
import org.artemis.artemismodel.polygon.PolygonIndicatorRequest;

@Slf4j
@RequiredArgsConstructor
public class PolygonProcessor {

    private final IndicatorRequestSender indicatorRequestSender;
    private final DataRequestSender dataRequestSender;

    public void processDataRequest(PolygonDataRequest request) {
        var type = request.getRequestType();
        var result = switch (PolygonEndpoint.getFromString(type)) {
            case POLYGON_ENDPOINT_AGGREGATES -> dataRequestSender.requestAggregate(request);
            case POLYGON_ENDPOINT_DAILY_OHLC -> dataRequestSender.requestDailyOhlc(request);
            case POLYGON_ENDPOINT_DAILY_OPEN_CLOSE -> dataRequestSender.requestDailyOpenClose(request);
            case POLYGON_ENDPOINT_PREVIOUS_OHLC -> dataRequestSender.requestPreviousOhlc(request);
            default -> throw new RuntimeException(String.format("Unknown data request code: %s", type));
        };
    }

    public void processIndicatorRequest(PolygonIndicatorRequest request) {
        var type = request.getRequestType();
        var result = switch (PolygonEndpoint.getFromString(type)) {
            case POLYGON_ENDPOINT_TECHNICAL_INDICATOR_SMA -> indicatorRequestSender.requestSma(request);
            case POLYGON_ENDPOINT_TECHNICAL_INDICATOR_EMA -> indicatorRequestSender.requestEma(request);
            case POLYGON_ENDPOINT_TECHNICAL_INDICATOR_MACD -> indicatorRequestSender.requestMacd(request);
            case POLYGON_ENDPOINT_TECHNICAL_INDICATOR_RSI -> indicatorRequestSender.requestRsi(request);
            default -> throw new RuntimeException(String.format("Unknown indicator request code: %s", type));
        };
    }
}
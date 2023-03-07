package org.artemis.artemispolygon.processor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.artemis.artemiscommon.polygon.PolygonEndpoint;
import org.artemis.artemismodel.polygon.PolygonDataRequest;
import org.artemis.artemismodel.polygon.PolygonIndicatorRequest;

@Slf4j
@RequiredArgsConstructor
public class PolygonProcessor {

    private final IndicatorProvider indicatorProvider;
    private final DataProvider dataProvider;

    public void processDataRequest(PolygonDataRequest request) {
        var type = request.getRequestType();
        var result = switch (PolygonEndpoint.getFromString(type)) {
            case POLYGON_ENDPOINT_AGGREGATES -> dataProvider.saveAggregates(request);
            case POLYGON_ENDPOINT_DAILY_OHLC -> dataProvider.saveDailyOhlc(request);
            case POLYGON_ENDPOINT_DAILY_OPEN_CLOSE -> dataProvider.saveDailyOpenClose(request);
            case POLYGON_ENDPOINT_PREVIOUS_OHLC -> dataProvider.savePreviousDailyOhlc(request);
            default -> throw new RuntimeException(String.format("Unknown data request code: %s", type));
        };
        log.info("Saved entities count: {}", result);
    }

    public void processIndicatorRequest(PolygonIndicatorRequest request) {
        var type = request.getRequestType();
        switch (PolygonEndpoint.getFromString(type)) {
            case POLYGON_ENDPOINT_TECHNICAL_INDICATOR_SMA -> indicatorProvider.saveSma(request);
            case POLYGON_ENDPOINT_TECHNICAL_INDICATOR_EMA -> indicatorProvider.saveEma(request);
            case POLYGON_ENDPOINT_TECHNICAL_INDICATOR_MACD -> indicatorProvider.saveMacd(request);
            case POLYGON_ENDPOINT_TECHNICAL_INDICATOR_RSI -> indicatorProvider.saveRsi(request);
            default -> throw new RuntimeException(String.format("Unknown indicator request code: %s", type));
        }
        log.info("Indicator {} value for symbol {} saved", type, request.getSymbol());
    }
}
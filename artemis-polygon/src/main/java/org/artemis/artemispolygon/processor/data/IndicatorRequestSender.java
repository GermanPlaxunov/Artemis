package org.artemis.artemispolygon.processor.data;

import lombok.RequiredArgsConstructor;
import org.artemis.artemismodel.polygon.PolygonIndicatorRequest;
import org.artemis.artemismodel.polygon.response.IndicatorResponse;
import org.artemis.artemispolygon.client.PolygonClient;

import static org.artemis.artemiscommon.utils.DateUtils.convertLocalDateTimeToString;

@RequiredArgsConstructor
public class IndicatorRequestSender {
    private final String apiKey;
    private final PolygonClient client;

    public IndicatorResponse requestSma(PolygonIndicatorRequest request) {
        var stockTicker = request.getSymbol();
        var timestamp = convertLocalDateTimeToString(request.getTimestamp());
        var timespan = request.getTimespan();
        var adjusted = request.getAdjusted();
        var window = request.getWindow();
        var seriesType = request.getSeriesType();
        var expandUnderlying = request.getExpandUnderlying();
        var order = request.getOrder();
        var limit = request.getLimit();
        return client.requestSma(stockTicker, timestamp, timespan,
                adjusted, window, seriesType, expandUnderlying,
                order, limit, apiKey).getBody();
    }

    public IndicatorResponse requestEma(PolygonIndicatorRequest request) {
        var stockTicker = request.getSymbol();
        var timestamp = convertLocalDateTimeToString(request.getTimestamp());
        var timespan = request.getTimespan();
        var adjusted = request.getAdjusted();
        var window = request.getWindow();
        var seriesType = request.getSeriesType();
        var expandUnderlying = request.getExpandUnderlying();
        var order = request.getOrder();
        var limit = request.getLimit();
        return client.requestEma(stockTicker, timestamp, timespan,
                adjusted, window, seriesType, expandUnderlying,
                order, limit, apiKey).getBody();
    }

    public IndicatorResponse requestMacd(PolygonIndicatorRequest request) {
        var stockTicker = request.getSymbol();
        var timestamp = convertLocalDateTimeToString(request.getTimestamp());
        var timespan = request.getTimespan();
        var adjusted = request.getAdjusted();
        var shortWindow = request.getShortWindow();
        var longWindow = request.getLongWindow();
        var signalWindow = request.getSignalWindow();
        var seriesType = request.getSeriesType();
        var expandUnderlying = request.getExpandUnderlying();
        var order = request.getOrder();
        var limit = request.getLimit();
        return client.requestMacd(stockTicker, timestamp, timespan,
                        adjusted, shortWindow, longWindow, signalWindow,
                        seriesType, expandUnderlying, order, limit, apiKey)
                .getBody();
    }

    public IndicatorResponse requestRsi(PolygonIndicatorRequest request) {
        var stockTicker = request.getSymbol();
        var timestamp = convertLocalDateTimeToString(request.getTimestamp());
        var timespan = request.getTimespan();
        var adjusted = request.getAdjusted();
        var window = request.getWindow();
        var seriesType = request.getSeriesType();
        var expandUnderlying = request.getExpandUnderlying();
        var order = request.getOrder();
        var limit = request.getLimit();
        return client.requestRsi(stockTicker, timestamp, timespan,
                adjusted, window, seriesType, expandUnderlying,
                order, limit, apiKey).getBody();
    }
}
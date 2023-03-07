package org.artemis.artemispolygon.processor;

import lombok.RequiredArgsConstructor;
import org.artemis.artemismodel.polygon.PolygonDataRequest;
import org.artemis.artemismodel.polygon.response.AggregateResponse;
import org.artemis.artemismodel.polygon.response.DailyOpenCloseResponse;
import org.artemis.artemismodel.polygon.response.DailyPreviousClose;
import org.artemis.artemismodel.polygon.response.DailyResponse;
import org.artemis.artemispolygon.client.PolygonClient;

import static org.artemis.artemiscommon.utils.DateUtils.convertLocalDateTimeToString;

@RequiredArgsConstructor
public class DataRequestSender {
    private final String apiKey;
    private final PolygonClient client;

    public AggregateResponse requestAggregate(PolygonDataRequest request) {
        var stockTicker = request.getStockTicker();
        var multiplier = request.getMultiplier();
        var timespan = request.getTimespan();
        var from = convertLocalDateTimeToString(request.getFrom());
        var to = convertLocalDateTimeToString(request.getTo());
        var adjusted = request.getAdjusted();
        var sort = request.getSort();
        var limit = request.getLimit();
        return client.requestAggregates(stockTicker, multiplier, timespan,
                        from, to, adjusted, sort, limit, apiKey)
                .getBody();
    }

    public DailyResponse requestDailyOhlc(PolygonDataRequest request) {
        var date = convertLocalDateTimeToString(request.getDate());
        var adjusted = request.getAdjusted();
        var includeOtc = request.getIncludeOtc();
        return client.requestDaily(date, adjusted, includeOtc, apiKey);
    }

    public DailyOpenCloseResponse requestDailyOpenClose(PolygonDataRequest request) {
        var stockTicker = request.getStockTicker();
        var date = convertLocalDateTimeToString(request.getDate());
        var adjusted = request.getAdjusted();
        return client.requestDailyOpenClose(stockTicker, date, adjusted, apiKey);
    }

    public DailyPreviousClose requestPreviousOhlc(PolygonDataRequest request) {
        var stockTicker = request.getStockTicker();
        var adjusted = request.getAdjusted();
        return client.requestPreviousDaily(stockTicker, adjusted, apiKey);
    }
}

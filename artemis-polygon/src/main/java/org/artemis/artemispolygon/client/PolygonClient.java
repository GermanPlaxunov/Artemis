package org.artemis.artemispolygon.client;

import org.artemis.artemismodel.polygon.response.*;

public interface PolygonClient {

    AggregateResponse requestAggregates(String stocksTicker, int multiplier,
                                        String timespan, String from, String to,
                                        boolean adjusted, String sort, int limit,
                                        String apiKey);

    DailyResponse requestDaily(String date, boolean adjusted,
                               boolean includeOtc, String apiKey);

    DailyOpenCloseResponse requestDailyOpenClose(String stockTicker, String date,
                                                 boolean adjusted, String apiKey);

    DailyPreviousClose requestPreviousDaily(String stockTicker, boolean adjusted,
                                            String apiKey);

    IndicatorResponse requestSma(String stockTicker, String timestamp,
                           String timespan, boolean adjusted,
                           int window, String seriesType,
                           boolean expandUnderlying, String order,
                           int limit, String apiKey);

    IndicatorResponse requestEma(String stockTicker, String timestamp,
                      String timespan, boolean adjusted,
                      int window, String seriesType,
                      boolean expandUnderlying, String order,
                      int limit, String apiKey);

    IndicatorResponse requestMacd(String stockTicker, String timestamp,
                       String timespan, boolean adjusted,
                       int shortWindow, int longWindow,
                       int signalWindow, String seriesType,
                       boolean expandUnderlying, String order,
                       int limit, String apiKey);

    IndicatorResponse requestRsi(String stockTicker, String timestamp,
                      String timespan, boolean adjusted,
                      int window, String seriesType,
                      boolean expandUnderlying, String order,
                      int limit, String apiKey);
}
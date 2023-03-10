package org.artemis.artemispolygon.client;

import org.artemis.artemismodel.polygon.response.*;
import org.springframework.http.ResponseEntity;

public interface PolygonClient {

    ResponseEntity<AggregateResponse> requestAggregates(String stocksTicker, int multiplier,
                                                        String timespan, String from, String to,
                                                        boolean adjusted, String sort, int limit,
                                                        String apiKey);

    ResponseEntity<DailyResponse> requestDaily(String date, boolean adjusted,
                                               boolean includeOtc, String apiKey);

    ResponseEntity<DailyOpenCloseResponse> requestDailyOpenClose(String stockTicker, String date,
                                                                 boolean adjusted, String apiKey);

    ResponseEntity<DailyPreviousClose> requestPreviousDaily(String stockTicker, boolean adjusted,
                                                            String apiKey);

    ResponseEntity<IndicatorResponse> requestSma(String stockTicker, String timestamp,
                                                 String timespan, boolean adjusted,
                                                 int window, String seriesType,
                                                 boolean expandUnderlying, String order,
                                                 int limit, String apiKey);

    ResponseEntity<IndicatorResponse> requestEma(String stockTicker, String timestamp,
                                                 String timespan, boolean adjusted,
                                                 int window, String seriesType,
                                                 boolean expandUnderlying, String order,
                                                 int limit, String apiKey);

    ResponseEntity<IndicatorResponse> requestMacd(String stockTicker, String timestamp,
                                                  String timespan, boolean adjusted,
                                                  int shortWindow, int longWindow,
                                                  int signalWindow, String seriesType,
                                                  boolean expandUnderlying, String order,
                                                  int limit, String apiKey);

    ResponseEntity<IndicatorResponse> requestRsi(String stockTicker, String timestamp,
                                                 String timespan, boolean adjusted,
                                                 int window, String seriesType,
                                                 boolean expandUnderlying, String order,
                                                 int limit, String apiKey);
}
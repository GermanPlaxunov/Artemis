package org.artemis.artemispolygon.client;

public interface PolygonClient {

    String requestAggregates(String stocksTicker, int multiplier,
                             String timespan, String from, String to,
                             boolean adjusted, String sort, int limit,
                             String apiKey);

    String requestDaily(String date, boolean adjusted,
                        boolean includeOtc, String apiKey);

    String requestDailyOpenClose(String stockTicker, String date,
                                 boolean adjusted, String apiKey);

    String requestPreviousDaily(String stockTicker, boolean adjusted,
                                String apiKey);

    String requestSma(String stockTicker, String timestamp,
                      String timespan, boolean adjusted,
                      int window, String seriesType,
                      boolean expandUnderlying, String order,
                      int limit, String apiKey);

    String requestEma(String stockTicker, String timestamp,
                      String timespan, boolean adjusted,
                      int window, String seriesType,
                      boolean expandUnderlying, String order,
                      int limit, String apiKey);

    String requestMacd(String stockTicker, String timestamp,
                       String timespan, boolean adjusted,
                       int shortWindow, int longWindow,
                       int signalWindow, String seriesType,
                       boolean expandUnderlying, String order,
                       int limit, String apiKey);

    String requestRsi(String stockTicker, String timestamp,
                      String timespan, boolean adjusted,
                      int window, String seriesType,
                      boolean expandUnderlying, String order,
                      int limit, String apiKey);
}
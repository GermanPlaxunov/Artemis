package org.artemis.artemiscommon.polygon;

import org.artemis.artemiscommon.utils.Utils;

public enum PolygonEndpoint {
    /**
     * Get aggregate bars for a stock over a given
     * date range in custom time window sizes.
     */
    POLYGON_ENDPOINT_AGGREGATES("p1", "v2/aggs/ticker/{stocksTicker}/range/{multiplier}/{timespan}/{from}/{to}"),
    /**
     * Get the daily open, high, low, and close
     * (OHLC) for the entire stocks/equities markets.
     */
    POLYGON_ENDPOINT_DAILY_OHLC("p2", "/v2/aggs/grouped/locale/us/market/stocks/{date}"),
    /**
     * Get the open, close and afterhours prices of
     * a stock symbol on a certain date.
     */
    POLYGON_ENDPOINT_DAILY_OPEN_CLOSE("p3", "/v1/open-close/{stocksTicker}/{date}"),
    /**
     * Get the previous day's open, high, low, and
     * close (OHLC) for the specified stock ticker.
     */
    POLYGON_ENDPOINT_PREVIOUS_OHLC("p4", "/v2/aggs/ticker/{stocksTicker}/prev"),
    /**
     * Get the simple moving average (SMA) for
     * a ticker symbol over a given time range.
     */
    POLYGON_ENDPOINT_TECHNICAL_INDICATOR_SMA("p5", "/v1/indicators/sma/{stockTicker}"),
    /**
     * Get the exponential moving average (EMA)
     * for a ticker symbol over a given time range.
     */
    POLYGON_ENDPOINT_TECHNICAL_INDICATOR_EMA("p6", "/v1/indicators/ema/{stockTicker}"),
    /**
     * Get moving average convergence/divergence (MACD)
     * data for a ticker symbol over a given time range.
     */
    POLYGON_ENDPOINT_TECHNICAL_INDICATOR_MACD("p7", "/v1/indicators/macd/{stockTicker}"),
    /**
     * Get the relative strength index (RSI) for
     * a ticker symbol over a given time range.
     */
    POLYGON_ENDPOINT_TECHNICAL_INDICATOR_RSI("p8", "/v1/indicators/rsi/{stockTicker}");

    private final String code;
    private final String endpoint;

    PolygonEndpoint(String code, String endpoint) {
        this.code = code;
        this.endpoint = endpoint;
    }

    public static boolean isDataCode(String code) {
        return Utils.in(code,
                POLYGON_ENDPOINT_AGGREGATES.code,
                POLYGON_ENDPOINT_DAILY_OHLC.code,
                POLYGON_ENDPOINT_PREVIOUS_OHLC.code,
                POLYGON_ENDPOINT_DAILY_OPEN_CLOSE.code);
    }

    public static boolean isSignalCode(String code) {
        return Utils.in(code,
                POLYGON_ENDPOINT_TECHNICAL_INDICATOR_RSI.code,
                POLYGON_ENDPOINT_TECHNICAL_INDICATOR_SMA.code,
                POLYGON_ENDPOINT_TECHNICAL_INDICATOR_EMA.code,
                POLYGON_ENDPOINT_TECHNICAL_INDICATOR_MACD.code);
    }

    public static PolygonEndpoint getFromString(String name) {
        for(var code : PolygonEndpoint.values()){
            if(code.code.equals(name)){
                return code;
            }
        }
        return null;
    }

    public static String getAggregate() {
        return POLYGON_ENDPOINT_AGGREGATES.code;
    }

    public static boolean isAggregate(String code) {
        return POLYGON_ENDPOINT_AGGREGATES.code.equals(code);
    }

    public static String getDailyOhlc() {
        return POLYGON_ENDPOINT_DAILY_OHLC.code;
    }

    public static boolean isDailyOhlc(String code) {
        return POLYGON_ENDPOINT_DAILY_OHLC.code.equals(code);
    }

    public static String getDailyOpenClose() {
        return POLYGON_ENDPOINT_DAILY_OPEN_CLOSE.code;
    }

    public static boolean isDailyOpenClose(String code) {
        return POLYGON_ENDPOINT_DAILY_OPEN_CLOSE.code.equals(code);
    }

    public static String getPreviousOhlc() {
        return POLYGON_ENDPOINT_PREVIOUS_OHLC.code;
    }

    public static boolean isPreviousOhlc(String code) {
        return POLYGON_ENDPOINT_PREVIOUS_OHLC.code.equals(code);
    }

    public static String getSma() {
        return POLYGON_ENDPOINT_TECHNICAL_INDICATOR_SMA.code;
    }

    public static boolean isSma(String code) {
        return POLYGON_ENDPOINT_TECHNICAL_INDICATOR_SMA.code.equals(code);
    }

    public static String getEma() {
        return POLYGON_ENDPOINT_TECHNICAL_INDICATOR_EMA.code;
    }

    public static boolean isEma(String code) {
        return POLYGON_ENDPOINT_TECHNICAL_INDICATOR_EMA.code.equals(code);
    }

    public static String getMacd() {
        return POLYGON_ENDPOINT_TECHNICAL_INDICATOR_MACD.code;
    }

    public static boolean isMacd(String code) {
        return POLYGON_ENDPOINT_TECHNICAL_INDICATOR_MACD.code.equals(code);
    }

    public static String getRsi() {
        return POLYGON_ENDPOINT_TECHNICAL_INDICATOR_RSI.code;
    }

    public static boolean isRsi(String code) {
        return POLYGON_ENDPOINT_TECHNICAL_INDICATOR_RSI.code.equals(code);
    }
}
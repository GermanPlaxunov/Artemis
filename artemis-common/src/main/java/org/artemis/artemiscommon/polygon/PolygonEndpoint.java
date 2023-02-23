package org.artemis.artemiscommon.polygon;

public enum PolygonEndpoint {
    /**
     * Get aggregate bars for a stock over a given
     * date range in custom time window sizes.
     */
    POLYGON_ENDPOINT_AGGREGATES("v2/aggs/ticker/{stocksTicker}/range/{multiplier}/{timespan}/{from}/{to}"),
    /**
     * Get the daily open, high, low, and close
     * (OHLC) for the entire stocks/equities markets.
     */
    POLYGON_ENDPOINT_DAILY_OHLC("/v2/aggs/grouped/locale/us/market/stocks/{date}"),
    /**
     * Get the open, close and afterhours prices of
     * a stock symbol on a certain date.
     */
    POLYGON_ENDPOINT_DAILY_OPEN_CLOSE("/v1/open-close/{stocksTicker}/{date}"),
    /**
     * Get the previous day's open, high, low, and
     * close (OHLC) for the specified stock ticker.
     */
    POLYGON_ENDPOINT_PREVIOUS_OHLC("/v2/aggs/ticker/{stocksTicker}/prev"),
    /**
     * Get the simple moving average (SMA) for
     * a ticker symbol over a given time range.
     */
    POLYGON_ENDPOINT_TECHNICAL_INDICATOR_SMA("/v1/indicators/sma/{stockTicker}"),
    /**
     * Get the exponential moving average (EMA)
     * for a ticker symbol over a given time range.
     */
    POLYGON_ENDPOINT_TECHNICAL_INDICATOR_EMA("/v1/indicators/ema/{stockTicker}"),
    /**
     * Get moving average convergence/divergence (MACD)
     * data for a ticker symbol over a given time range.
     */
    POLYGON_ENDPOINT_TECHNICAL_INDICATOR_MACD("/v1/indicators/macd/{stockTicker}"),
    /**
     * Get the relative strength index (RSI) for
     * a ticker symbol over a given time range.
     */
    POLYGON_ENDPOINT_TECHNICAL_INDICATOR_RSI("/v1/indicators/rsi/{stockTicker}");

    private final String name;

    PolygonEndpoint(String name) {
        this.name = name;
    }

    public static String getAggregate() {
        return POLYGON_ENDPOINT_AGGREGATES.name;
    }

    public static String getDailyOhlc() {
        return POLYGON_ENDPOINT_DAILY_OHLC.name;
    }

    public static String getDailyOpenClose() {
        return POLYGON_ENDPOINT_DAILY_OPEN_CLOSE.name;
    }

    public static String getPreviousOhlc() {
        return POLYGON_ENDPOINT_PREVIOUS_OHLC.name;
    }

    public static String getSma() {
        return POLYGON_ENDPOINT_TECHNICAL_INDICATOR_SMA.name;
    }

    public static String getEma() {
        return POLYGON_ENDPOINT_TECHNICAL_INDICATOR_EMA.name;
    }

    public static String getMacd() {
        return POLYGON_ENDPOINT_TECHNICAL_INDICATOR_MACD.name;
    }

    public static String getRsi() {
        return POLYGON_ENDPOINT_TECHNICAL_INDICATOR_RSI.name;
    }
}
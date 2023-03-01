package org.artemis.artemiscommon.polygon;

public enum IndicatorType {
    INDICATOR_TYPE_SMA("sma"),
    INDICATOR_TYPE_EMA("ema"),
    INDICATOR_TYPE_MACD("macd"),
    INDICATOR_TYPE_RSI("rsi");

    private final String name;

    IndicatorType(String name) {
        this.name = name;
    }
}

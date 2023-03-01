package org.artemis.artemismodel.polygon;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PolygonIndicatorRequest {
    /**
     * The kind of the request to choose
     * the correct endpoint.
     * */
    private String requestType;
    /**
     * The ticker symbol for which to get
     * simple moving average (SMA) data.
     */
    private String symbol;
    /**
     * Query by timestamp. Either a date with the
     * format YYYY-MM-DD or a millisecond timestamp.
     */
    private LocalDateTime timestamp;
    /**
     * The size of the aggregate time window.
     */
    private String timespan;
    /**
     * Whether the aggregates used to calculate the simple
     * moving average are adjusted for splits. By default,
     * aggregates are adjusted. Set this to false to get
     * results that are NOT adjusted for splits.
     */
    private Boolean adjusted;
    /**
     * The window size used to calculate the simple
     * moving average (SMA). i.e. a window size of 10
     * with daily aggregates would result in a 10-day
     * moving average.
     */
    private Integer window;
    /**
     * The short window size used to calculate MACD data.
     */
    private Integer shortWindow;
    /**
     * The long window size used to calculate MACD data.
     */
    private Integer longWindow;
    /**
     * The window size used to calculate the MACD signal line.
     */
    private Integer signalWindow;
    /**
     * The price in the aggregate which will be used to
     * calculate the MACD. i.e. 'close' will result in
     * using close prices to calculate the MACD.
     */
    private String seriesType;
    /**
     * Whether to include the aggregates used
     * to calculate this indicator in the response.
     */
    private Boolean expandUnderlying;
    /**
     * The order in which to return the results,
     * ordered by timestamp.
     */
    private String order;
    /**
     * Limit the number of results returned,
     * default is 10 and max is 5000
     */
    private Integer limit;
}

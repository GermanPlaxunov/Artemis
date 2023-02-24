package org.artemis.artemismodel.polygon;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PolygonDataRequest {
    /**
     * The kind of the request to choose
     * the correct endpoint.
     * */
    private String requestType;
    /**
     * The ticker symbol of the stock.
     */
    private String stockTicker;
    /**
     * The size of timespan multiplier.
     */
    private Integer multiplier;
    /**
     * The size of the time window.
     */
    private String timespan;
    /**
     * The start of the aggregate time window.
     * Either a date with the format YYYY-MM-DD
     * or a millisecond timestamp.
     */
    private LocalDateTime from;
    /**
     * The end of the aggregate time window.
     * Either a date with the format YYYY-MM-DD
     * or a millisecond timestamp.
     */
    private LocalDateTime to;
    /**
     * The beginning date for the aggregate window.
     */
    private LocalDateTime date;
    /**
     * Whether the results are adjusted for splits.
     * By default, results are adjusted. Set this to false
     * to get results that are NOT adjusted for splits.
     */
    private Boolean adjusted;
    /**
     * Include OTC securities in the response.
     * Default is false (don't include OTC securities).
     */
    private Boolean includeOtc;
    /**
     * Sort the results by timestamp. asc will return results
     * in ascending order (oldest at the top), desc will return
     * results in descending order (newest at the top).
     */
    private String sort;
    /**
     * Limits the number of base aggregates queried to create
     * the aggregate results. Max 50000 and Default 5000.
     */
    private Integer limit;
}

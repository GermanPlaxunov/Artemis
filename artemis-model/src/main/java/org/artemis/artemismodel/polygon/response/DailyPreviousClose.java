package org.artemis.artemismodel.polygon.response;

import lombok.Data;

import java.util.List;

@Data
public class DailyPreviousClose {
    /**
     * The exchange symbol that this item is traded under.
     */
    private String ticker;
    /**
     * Whether this response was adjusted for splits.
     * */
    private Boolean adjusted;
    /**
     * The number of aggregates (minute or day) used to generate the response.
     * */
    private Integer queryCount;
    /***
     * A request id assigned by the server.
     */
    private String requestId;
    /***
     * The total number of results for this request.
     */
    private Integer resultsCount;
    /***
     * The status of this request's response.
     */
    private String status;
    /***
     * Response data.
     */
    private List<TradeData> results;
}

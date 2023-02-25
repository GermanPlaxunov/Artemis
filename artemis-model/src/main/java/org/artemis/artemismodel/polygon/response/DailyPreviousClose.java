package org.artemis.artemismodel.polygon.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DailyPreviousClose {
    /**
     * The exchange symbol that this item is traded under.
     */
    @JsonProperty("ticker")
    private String ticker;
    /**
     * Whether this response was adjusted for splits.
     * */
    @JsonProperty("adjusted")
    private Boolean adjusted;
    /**
     * The number of aggregates (minute or day) used to generate the response.
     * */
    @JsonProperty("queryCount")
    private Integer queryCount;
    /***
     * A request id assigned by the server.
     */
    @JsonProperty("request_id")
    private String requestId;
    /***
     * The total number of results for this request.
     */
    @JsonProperty("resultsCount")
    private Integer resultsCount;
    /***
     * The status of this request's response.
     */
    @JsonProperty("status")
    private String status;
    /***
     * Response data.
     */
    @JsonProperty("results")
    private List<TradeData> results;
}

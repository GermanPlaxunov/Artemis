package org.artemis.artemismodel.polygon.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IndicatorResponse {
    /***
     * If present, this value can be used to
     * fetch the next page of data.
     */
    @JsonProperty("next_url")
    private String nexUrl;
    /***
     * A request id assigned by the server.
     */
    @JsonProperty("request_id")
    private String requestId;
    /***n
    private String status;
    /**
     * Index data.
     */
    @JsonProperty("results")
    private IndexResult results;
}

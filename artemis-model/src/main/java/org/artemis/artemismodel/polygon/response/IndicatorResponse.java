package org.artemis.artemismodel.polygon.response;

import lombok.Data;

import java.util.List;

@Data
public class IndicatorResponse {
    /***
     * If present, this value can be used to
     * fetch the next page of data.
     */
    private String nexUrl;
    /***
     * A request id assigned by the server.
     */
    private String requestId;
    /***
     * The status of this request's response.
     */
    private String status;
    /**
     * Index data.
     */
    private List<IndexResult> results;
}

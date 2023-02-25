package org.artemis.artemismodel.polygon.response;

import lombok.Data;

import java.util.List;

@Data
public class DailyResponse {
    private Boolean adjusted;
    private Integer queryCount;
    private String requestId;
    private Integer resultsCount;
    private String status;
    private List<TradeData> results;
}

package org.artemis.artemismodel.polygon.response;

import lombok.Data;

import java.util.List;

@Data
public class Underlying {
    /***
     * The aggregates used to calculate this
     * indicator in the response.
     */
    private List<TradeData> aggregates;
    /***
     * The URL which can be used to request the
     * underlying aggregates used in this request.
     */
    private String url;
}

package org.artemis.artemismodel.polygon.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IndexValues {
    /***
     * The indicator value for this period.
     */
    @JsonProperty("histogram")
    private Integer histogram;
    /***
     * The indicator value for this period.
     */
    @JsonProperty("signal")
    private Double signal;
    /***
     * The Unix Msec timestamp from the last
     * aggregate used in this calculation.
     */
    @JsonProperty("timestamp")
    private Integer timestamp;
    /***
     * The indicator value for this period.
     */
    @JsonProperty("value")
    private Double value;
}
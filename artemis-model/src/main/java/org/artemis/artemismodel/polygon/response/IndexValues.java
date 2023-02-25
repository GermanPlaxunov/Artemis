package org.artemis.artemismodel.polygon.response;

import lombok.Data;

@Data
public class IndexValues {
    /***
     * The indicator value for this period.
     */
    private Integer histogram;
    /***
     * The indicator value for this period.
     */
    private Double signal;
    /***
     * The Unix Msec timestamp from the last
     * aggregate used in this calculation.
     */
    private Integer timestamp;
    /***
     * The indicator value for this period.
     */
    private Double number;
}
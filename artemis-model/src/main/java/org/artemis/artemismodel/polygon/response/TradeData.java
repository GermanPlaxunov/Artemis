package org.artemis.artemismodel.polygon.response;

import lombok.Data;

@Data
public class TradeData {
    /**
     * The exchange symbol that this item is traded under.
     * */
    private String T;
    /**
     * The close price for the symbol in the given time period.
     */
    private Double c;
    /**
     * The highest price for the symbol in the given time period.
     */
    private Double h;
    /**
     * The lowest price for the symbol in the given time period.
     */
    private Double l;
    /**
     * The open price for the symbol in the given time period.
     */
    private Double o;
    /**
     * The number of transactions in the aggregate window.
     */
    private Long n;
    /**
     * Whether this aggregate is for an OTC ticker.
     * This field will be left off if false.
     */
    private Boolean otc;
    /**
     * The Unix Msec timestamp for the start of the aggregate window.
     */
    private Integer t;
    /**
     * The trading volume of the symbol in the given time period.
     */
    private Long v;
    /**
     * The volume weighted average price.
     */
    private Double vw;
}

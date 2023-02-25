package org.artemis.artemismodel.polygon.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TradeData {
    /**
     * The exchange symbol that this item is traded under.
     */
    @JsonProperty("T")
    private String T;
    /**
     * The close price for the symbol in the given time period.
     */
    @JsonProperty("c")
    private Double c;
    /**
     * The highest price for the symbol in the given time period.
     */
    @JsonProperty("h")
    private Double h;
    /**
     * The lowest price for the symbol in the given time period.
     */
    @JsonProperty("l")
    private Double l;
    /**
     * The open price for the symbol in the given time period.
     */
    @JsonProperty("o")
    private Double o;
    /**
     * The number of transactions in the aggregate window.
     */
    @JsonProperty("n")
    private Long n;
    /**
     * Whether this aggregate is for an OTC ticker.
     * This field will be left off if false.
     */
    @JsonProperty("otc")
    private Boolean otc;
    /**
     * The Unix Msec timestamp for the start of the aggregate window.
     */
    @JsonProperty("t")
    private Integer t;
    /**
     * The trading volume of the symbol in the given time period.
     */
    @JsonProperty("v")
    private Long v;
    /**
     * The volume weighted average price.
     */
    @JsonProperty("vw")
    private Double vw;
}
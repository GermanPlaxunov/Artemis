package org.artemis.artemismodel.polygon.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TradeData {
    /**
     * The exchange symbol that this item is traded under.
     */
    @JsonProperty("T")
    private String symbol;
    /**
     * The close price for the symbol in the given time period.
     */
    @JsonProperty("c")
    private Double close;
    /**
     * The highest price for the symbol in the given time period.
     */
    @JsonProperty("h")
    private Double high;
    /**
     * The lowest price for the symbol in the given time period.
     */
    @JsonProperty("l")
    private Double low;
    /**
     * The open price for the symbol in the given time period.
     */
    @JsonProperty("o")
    private Double open;
    /**
     * The number of transactions in the aggregate window.
     */
    @JsonProperty("n")
    private Long transactionsCount;
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
    private Long date;
    /**
     * The trading volume of the symbol in the given time period.
     */
    @JsonProperty("v")
    private Long volume;
    /**
     * The volume weighted average price.
     */
    @JsonProperty("vw")
    private Double weightedVolume;
}
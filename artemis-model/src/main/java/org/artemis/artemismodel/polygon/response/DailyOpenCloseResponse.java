package org.artemis.artemismodel.polygon.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DailyOpenCloseResponse {
    /**
     * The close price of the ticker symbol in after hours trading.
     */
    @JsonProperty("afterHours")
    private Double afterHours;
    /**
     * The close price for the symbol in the given time period.
     */
    @JsonProperty("close")
    private Double close;
    /**
     * The requested date.
     */
    @JsonProperty("from")
    private String from;
    /**
     * The highest price for the symbol in the given time period.
     */
    @JsonProperty("high")
    private Double high;
    /**
     * The lowest price for the symbol in the given time period.
     */
    @JsonProperty("low")
    private Double low;
    /**
     * The open price for the symbol in the given time period.
     */
    @JsonProperty("open")
    private Double open;
    /**
     * Whether this aggregate is for an OTC ticker.
     * This field will be left off if false.
     */
    @JsonProperty("otc")
    private Boolean otc;
    /**
     * The open price of the ticker symbol in pre-market trading.
     */
    @JsonProperty("preMarket")
    private Integer preMarket;
    /**
     * The status of this request's response.
     */
    @JsonProperty("status")
    private String status;
    /**
     * The exchange symbol that this item is traded under.
     */
    @JsonProperty("symbol")
    private String symbol;
    /**
     * The trading volume of the symbol in the given time period.
     */
    @JsonProperty("volume")
    private Double volume;
}
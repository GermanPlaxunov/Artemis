package org.artemis.artemismodel.polygon.response;

import lombok.Data;

@Data
public class DailyOpenCloseResponse {
    /**
     * The close price of the ticker symbol in after hours trading.
     */
    private Double afterHours;
    /**
     * The close price for the symbol in the given time period.
     */
    private Double close;
    /**
     * The requested date.
     */
    private String from;
    /**
     * The highest price for the symbol in the given time period.
     */
    private Double high;
    /**
     * The lowest price for the symbol in the given time period.
     */
    private Double low;
    /**
     * The open price for the symbol in the given time period.
     */
    private Double open;
    /**
     * Whether this aggregate is for an OTC ticker.
     * This field will be left off if false.
     */
    private Boolean otc;
    /**
     * The open price of the ticker symbol in pre-market trading.
     */
    private Integer preMarket;
    /**
     * The status of this request's response.
     */
    private String status;
    /**
     * The exchange symbol that this item is traded under.
     */
    private String symbol;
    /**
     * The trading volume of the symbol in the given time period.
     */
    private Double volume;
}
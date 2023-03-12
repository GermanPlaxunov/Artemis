package org.artemis.artemismarket.rest;

public interface MarketApi {

    void openShortPosition();

    void openLongPosition();

    void closePosition(String hash);

    void getPositionInfo(String hash);

    void getStockPrice();
}

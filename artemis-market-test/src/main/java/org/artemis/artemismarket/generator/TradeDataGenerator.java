package org.artemis.artemismarket.generator;

import org.artemis.artemisdata.market.entities.TradeDataEntity;
import org.artemis.artemismodel.polygon.response.TradeData;

public class TradeDataGenerator {

    public TradeData generateTradeData() {
        return new TradeData();
    }

    private TradeDataEntity createNewTradeData(TradeDataEntity lastTradeData) {

    }
}
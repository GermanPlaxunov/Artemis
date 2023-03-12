package org.artemis.artemismarket.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MarketController implements MarketApi {

    @Override
    @PostMapping(path = "/openShortPosition")
    public void openShortPosition() {

    }

    @Override
    @PostMapping(path = "/openLongPosition")
    public void openLongPosition() {

    }

    @Override
    @PostMapping(path = "/closePosition")
    public void closePosition(String hash) {

    }

    @Override
    @PostMapping(path = "/getPositionInfo")
    public void getPositionInfo(String hash) {

    }

    @Override
    @PostMapping(path = "/getStockPrice")
    public void getStockPrice() {

    }

}

package org.artemis.artemispolygon.processor.data;

import lombok.RequiredArgsConstructor;
import org.artemis.artemisdata.polygon.service.interfaces.IndicatorService;
import org.artemis.artemismodel.polygon.PolygonIndicatorRequest;

@RequiredArgsConstructor
public class IndicatorProvider {
    private final IndicatorService indicatorService;
    private final IndicatorRequestSender sender;

    public void saveSma(PolygonIndicatorRequest request) {
        var symbol = request.getSymbol();
        var response = sender.requestSma(request);
        indicatorService.saveSma(symbol, response.getResults().getValues().get(0).getValue());
    }

    public void saveEma(PolygonIndicatorRequest request) {
        var symbol = request.getSymbol();
        var response = sender.requestEma(request);
        indicatorService.saveEma(symbol, response.getResults().getValues().get(0).getValue());
    }

    public void saveMacd(PolygonIndicatorRequest request) {
        var symbol = request.getSymbol();
        var response = sender.requestMacd(request);
        indicatorService.saveMacd(symbol, response.getResults().getValues().get(0).getValue());
    }

    public void saveRsi(PolygonIndicatorRequest request) {
        var symbol = request.getSymbol();
        var response = sender.requestRsi(request);
        indicatorService.saveRsi(symbol, response.getResults().getValues().get(0).getValue());
    }
}
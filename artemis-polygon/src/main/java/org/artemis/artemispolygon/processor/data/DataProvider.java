package org.artemis.artemispolygon.processor.data;

import lombok.RequiredArgsConstructor;
import org.artemis.artemiscommon.utils.DateUtils;
import org.artemis.artemisdata.polygon.entities.EndOfDayEntity;
import org.artemis.artemisdata.polygon.service.interfaces.EndOfDayService;
import org.artemis.artemismodel.polygon.PolygonDataRequest;

import java.util.ArrayList;

@RequiredArgsConstructor
public class DataProvider {
    private final EndOfDayService endOfDayService;
    private final DataRequestSender sender;

    public long saveAggregates(PolygonDataRequest request) {
        var response = sender.requestAggregate(request);
        var symbol = response.getTicker();
        var list = new ArrayList<EndOfDayEntity>();
        for (var aggr : response.getResults()) {
            var date = DateUtils.getLdtFromMills(aggr.getDate());
            var entity = new EndOfDayEntity()
                    .setSymbol(symbol)
                    .setDate(date)
                    .setOpen(aggr.getOpen())
                    .setLow(aggr.getLow())
                    .setHigh(aggr.getHigh())
                    .setVolume(aggr.getVolume())
                    .setWeightedVolume(aggr.getWeightedVolume())
                    .setTransactionsCount(aggr.getTransactionsCount());
            list.add(entity);
        }
        endOfDayService.saveAll(list);
        return list.size();
    }

    public long saveDailyOhlc(PolygonDataRequest request) {
        var response = sender.requestDailyOhlc(request);
        var list = new ArrayList<EndOfDayEntity>();
        for (var res : response.getResults()) {
            var date = DateUtils.getLdtFromMills(res.getDate());
            list.add(new EndOfDayEntity()
                    .setSymbol(res.getSymbol())
                    .setClose(res.getClose())
                    .setHigh(res.getHigh())
                    .setLow(res.getLow())
                    .setTransactionsCount(res.getTransactionsCount())
                    .setOpen(res.getOpen())
                    .setDate(date)
                    .setVolume(res.getVolume())
                    .setWeightedVolume(res.getWeightedVolume()));
        }
        endOfDayService.saveAll(list);
        return list.size();
    }

    public long saveDailyOpenClose(PolygonDataRequest request) {
        var response = sender.requestDailyOpenClose(request);
        var entity = new EndOfDayEntity()
                .setSymbol(response.getSymbol())
                .setOpen(response.getOpen())
                .setLow(response.getLow())
                .setHigh(response.getHigh())
                .setClose(response.getClose())
                .setVolume(response.getVolume());
        endOfDayService.save(entity);
        return 1L;
    }

    public long savePreviousDailyOhlc(PolygonDataRequest request) {
        var response = sender.requestPreviousOhlc(request);
        var list = new ArrayList<EndOfDayEntity>();
        for (var entry : response.getResults()) {
            list.add(new EndOfDayEntity()
                    .setSymbol(entry.getSymbol())
                    .setOpen(entry.getOpen())
                    .setLow(entry.getLow())
                    .setHigh(entry.getHigh())
                    .setClose(entry.getClose())
                    .setVolume(entry.getVolume()));
        }
        endOfDayService.saveAll(list);
        return list.size();
    }
}
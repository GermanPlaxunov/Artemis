package org.artemis.artemispolygon.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "polygonClient", url = "${polygon.api.url}")
public interface PolygonFeignClient extends PolygonClient {

    @Override
    @GetMapping(path = "/v2/aggs/ticker/{stocksTicker}/range/{multiplier}/{timespan}/{from}/{to}")
    String requestAggregates(@PathVariable("stocksTicker") String stocksTicker,
                             @PathVariable("multiplier") int multiplier,
                             @PathVariable("timespan") String timespan,
                             @PathVariable("from") String from,
                             @PathVariable("to") String to,
                             @RequestParam("adjusted") boolean adjusted,
                             @RequestParam("sort") String sort,
                             @RequestParam("limit") int limit,
                             @RequestParam("apiKey") String apiKey);

    @Override
    @GetMapping(path = "/v2/aggs/grouped/locale/us/market/stocks/{date}")
    String requestDaily(@PathVariable("date") String date,
                        @RequestParam("adjusted") boolean adjusted,
                        @RequestParam("include_otc") boolean includeOtc,
                        @RequestParam("apiKey") String apiKey);

    @Override
    @GetMapping(path = "/v1/open-close/{stocksTicker}/{date}")
    String requestDailyOpenClose(@PathVariable("stocksTicker") String stocksTicker,
                                 @PathVariable("date") String date,
                                 @RequestParam("adjust") boolean adjusted,
                                 @RequestParam("apiKey") String apiKey);

    @Override
    @GetMapping(path = "/v2/aggs/ticker/{stocksTicker}/prev")
    String requestPreviousDaily(@PathVariable("stocksTicker") String stockTicker,
                                @RequestParam("adjusted") boolean adjusted,
                                @RequestParam("apiKey") String apiKey);

    @Override
    @GetMapping(path = "/v1/indicators/sma/{stockTicker}")
    String requestSma(@PathVariable("stockTicker") String stockTicker,
                      @RequestParam("timestamp") String timestamp,
                      @RequestParam("timespan") String timespan,
                      @RequestParam("adjusted") boolean adjusted,
                      @RequestParam("window") int window,
                      @RequestParam("series_type") String seriesType,
                      @RequestParam("expand_underlying") boolean expandUnderlying,
                      @RequestParam("order") String order,
                      @RequestParam("limit") int limit,
                      @RequestParam("apiKey") String apiKey);

    @Override
    @GetMapping(path = "/v1/indicators/ema/{stockTicker}")
    String requestEma(@PathVariable("stockTicker") String stockTicker,
                      @RequestParam("timestamp") String timestamp,
                      @RequestParam("timespan") String timespan,
                      @RequestParam("adjusted") boolean adjusted,
                      @RequestParam("window") int window,
                      @RequestParam("series_type") String seriesType,
                      @RequestParam("expand_underlying") boolean expandUnderlying,
                      @RequestParam("order") String order,
                      @RequestParam("limit") int limit,
                      @RequestParam("apiKey") String apiKey);

    @Override
    @GetMapping(path = "/v1/indicators/macd/{stockTicker}")
    String requestMacd(@PathVariable("stockTicker") String stockTicker,
                       @RequestParam("timestamp") String timestamp,
                       @RequestParam("timespan") String timespan,
                       @RequestParam("adjusted") boolean adjusted,
                       @RequestParam("short_window") int shortWindow,
                       @RequestParam("long_window") int longWindow,
                       @RequestParam("signal_window") int signalWindow,
                       @RequestParam("series_type") String seriesType,
                       @RequestParam("expand_underlying") boolean expandUnderlying,
                       @RequestParam("order") String order,
                       @RequestParam("limit") int limit,
                       @RequestParam("apiKey") String apiKey);

    @Override
    @GetMapping(path = "/v1/indicators/rsi/{stockTicker}")
    String requestRsi(@PathVariable("stockTicker") String stockTicker,
                      @RequestParam("timestamp") String timestamp,
                      @RequestParam("timespan") String timespan,
                      @RequestParam("adjusted") boolean adjusted,
                      @RequestParam("window") int window,
                      @RequestParam("series_type") String seriesType,
                      @RequestParam("expand_underlying") boolean expandUnderlying,
                      @RequestParam("order") String order,
                      @RequestParam("limit") int limit,
                      @RequestParam("apiKey") String apiKey);
}
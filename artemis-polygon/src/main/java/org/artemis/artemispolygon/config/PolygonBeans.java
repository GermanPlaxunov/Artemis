package org.artemis.artemispolygon.config;

import org.artemis.artemispolygon.client.PolygonClient;
import org.artemis.artemispolygon.client.PolygonDecoder;
import org.artemis.artemispolygon.client.PolygonFeignClient;
import org.artemis.artemispolygon.processor.DataRequestSender;
import org.artemis.artemispolygon.processor.IndicatorRequestSender;
import org.artemis.artemispolygon.processor.PolygonProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackageClasses = PolygonFeignClient.class)
public class PolygonBeans {

    @Bean
    public PolygonDecoder polygonDecoder() {
        return new PolygonDecoder();
    }

    @Bean
    public PolygonProcessor polygonProcessor(IndicatorRequestSender indicatorRequestSender,
                                             DataRequestSender dataRequestSender) {
        return new PolygonProcessor(indicatorRequestSender, dataRequestSender);
    }

    @Bean
    public IndicatorRequestSender indicatorRequestSender(PolygonClient client,
                                                         @Value("${polygon.api.key}") String apiKey) {
        return new IndicatorRequestSender(apiKey, client);
    }

    @Bean
    public DataRequestSender dataRequestSender(PolygonClient client,
                                               @Value("${polygon.api.key}") String apiKey) {
        return new DataRequestSender(apiKey, client);
    }

}

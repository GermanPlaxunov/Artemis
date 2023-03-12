package org.artemis.artemispolygon.config;

import org.artemis.artemisdata.polygon.repository.EndOfDayRepository;
import org.artemis.artemisdata.polygon.repository.IndicatorRepository;
import org.artemis.artemisdata.polygon.service.impl.EndOfDayServiceImpl;
import org.artemis.artemisdata.polygon.service.impl.IndicatorServiceImpl;
import org.artemis.artemisdata.polygon.service.interfaces.EndOfDayService;
import org.artemis.artemisdata.polygon.service.interfaces.IndicatorService;
import org.artemis.artemispolygon.client.PolygonClient;
import org.artemis.artemispolygon.client.PolygonFeignClient;
import org.artemis.artemispolygon.processor.PolygonProcessor;
import org.artemis.artemispolygon.processor.data.DataProvider;
import org.artemis.artemispolygon.processor.data.DataRequestSender;
import org.artemis.artemispolygon.processor.data.IndicatorProvider;
import org.artemis.artemispolygon.processor.data.IndicatorRequestSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableFeignClients(clients = {PolygonFeignClient.class})
@EntityScan(basePackages = {"org.artemis.artemisdata.polygon.entities"})
@EnableJpaRepositories(basePackageClasses = {IndicatorRepository.class,
        EndOfDayRepository.class
})
public class PolygonBeans {

    @Bean
    public PolygonProcessor polygonProcessor(IndicatorProvider indicatorProvider,
                                             DataProvider dataProvider) {
        return new PolygonProcessor(indicatorProvider, dataProvider);
    }

    @Bean
    public IndicatorRequestSender indicatorRequestSender(PolygonFeignClient client,
                                                         @Value("${polygon.api.key}") String apiKey) {
        return new IndicatorRequestSender(apiKey, client);
    }

    @Bean
    public DataRequestSender dataRequestSender(PolygonClient client,
                                               @Value("${polygon.api.key}") String apiKey) {
        return new DataRequestSender(apiKey, client);
    }

    @Bean
    public EndOfDayService endOfDayService(EndOfDayRepository repository) {
        return new EndOfDayServiceImpl(repository);
    }

    @Bean
    public IndicatorService indicatorService(IndicatorRepository repository) {
        return new IndicatorServiceImpl(repository);
    }

    @Bean
    public DataProvider dataProvider(EndOfDayService endOfDayService,
                                     DataRequestSender dataRequestSender) {
        return new DataProvider(endOfDayService, dataRequestSender);
    }

    @Bean
    public IndicatorProvider indicatorProvider(IndicatorService indicatorService,
                                               IndicatorRequestSender indicatorRequestSender) {
        return new IndicatorProvider(indicatorService, indicatorRequestSender);
    }
}
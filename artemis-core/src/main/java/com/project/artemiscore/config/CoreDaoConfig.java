package com.project.artemiscore.config;

import org.artemis.artemisdata.polygon.repository.EndOfDayRepository;
import org.artemis.artemisdata.polygon.repository.IndicatorRepository;
import org.artemis.artemisdata.polygon.service.impl.EndOfDayServiceImpl;
import org.artemis.artemisdata.polygon.service.impl.IndicatorServiceImpl;
import org.artemis.artemisdata.polygon.service.interfaces.EndOfDayService;
import org.artemis.artemisdata.polygon.service.interfaces.IndicatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = {
        EndOfDayRepository.class, IndicatorRepository.class
})
public class CoreDaoConfig {

    @Bean
    public IndicatorService indicatorService(IndicatorRepository repository) {
        return new IndicatorServiceImpl(repository);
    }

    @Bean
    public EndOfDayService endOfDayService(EndOfDayRepository repository) {
        return new EndOfDayServiceImpl(repository);
    }
}

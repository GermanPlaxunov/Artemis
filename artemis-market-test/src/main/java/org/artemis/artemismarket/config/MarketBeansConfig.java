package org.artemis.artemismarket.config;

import org.artemis.artemisdata.polygon.repository.EndOfDayRepository;
import org.artemis.artemisdata.polygon.service.impl.EndOfDayServiceImpl;
import org.artemis.artemisdata.polygon.service.interfaces.EndOfDayService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = EndOfDayRepository.class)
public class MarketBeansConfig {

    @Bean
    public EndOfDayService endOfDayService(EndOfDayRepository repository) {
        return new EndOfDayServiceImpl(repository);
    }

}

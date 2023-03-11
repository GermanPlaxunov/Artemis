package org.project.artemiscore.config;

import org.artemis.artemisdata.polygon.repository.AnalyzeDataTaskRepository;
import org.artemis.artemisdata.polygon.repository.IndicatorRepository;
import org.artemis.artemisdata.polygon.repository.UploadDataTaskRepository;
import org.project.artemiscore.client.PolygonClient;
import org.project.artemiscore.client.PolygonFeignClient;
import org.project.artemiscore.core.processor.CoreProcessor;
import org.project.artemiscore.core.processor.data.DataGapsCheck;
import org.project.artemiscore.core.processor.data.date.DateGapsCheck;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableFeignClients(clients = PolygonFeignClient.class)
@EnableJpaRepositories(basePackageClasses = {
        IndicatorRepository.class,
        UploadDataTaskRepository.class,
        AnalyzeDataTaskRepository.class
})
@EntityScan(basePackages = "org.artemis.artemisdata.polygon.entities")
public class CoreBeansConfig {

    @Bean
    public CoreProcessor coreProcessor(PolygonClient polygonClient) {
        return new CoreProcessor(polygonClient);
    }

    @Bean
    public DateGapsCheck dateGapsCheck() {
        return new DateGapsCheck();
    }

    @Bean
    public DataGapsCheck dataGapsCheck(DateGapsCheck dateGapsCheck) {
        return new DataGapsCheck(dateGapsCheck);
    }

}
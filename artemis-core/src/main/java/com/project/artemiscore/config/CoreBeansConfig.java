package com.project.artemiscore.config;

import com.project.artemiscore.client.PolygonFeignClient;
import com.project.artemiscore.core.processor.CoreProcessor;
import org.artemis.artemisdata.polygon.repository.AnalyzeDataTaskRepository;
import org.artemis.artemisdata.polygon.repository.IndicatorRepository;
import org.artemis.artemisdata.polygon.repository.UploadDataTaskRepository;
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
    public CoreProcessor coreProcessor(){
        return new CoreProcessor();
    }

}

package org.project.artemisgate.config;

import org.artemis.artemisdata.polygon.repository.AnalyzeDataTaskRepository;
import org.artemis.artemisdata.polygon.repository.IndicatorRepository;
import org.artemis.artemisdata.polygon.repository.UploadDataTaskRepository;
import org.artemis.artemisdata.polygon.service.impl.AnalyzeDataTaskServiceImpl;
import org.artemis.artemisdata.polygon.service.impl.UploadDataTaskServiceImpl;
import org.artemis.artemisdata.polygon.service.interfaces.AnalyzeDataTaskService;
import org.artemis.artemisdata.polygon.service.interfaces.UploadDataTaskService;
import org.project.artemisgate.client.CoreFeignClient;
import org.project.artemisgate.processor.GateProcessor;
import org.project.artemisgate.task.builder.TriggerTaskBuilder;
import org.project.artemisgate.task.mapper.AnalyzeDataTaskMapper;
import org.project.artemisgate.task.mapper.UploadDataTaskMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableFeignClients(clients = CoreFeignClient.class)
@EnableJpaRepositories(basePackageClasses = {
        IndicatorRepository.class,
        UploadDataTaskRepository.class,
        AnalyzeDataTaskRepository.class
})
@EntityScan(basePackages = "org.artemis.artemisdata.polygon.entities")
public class GateBeansConfig {

    @Bean
    public AnalyzeDataTaskMapper analyzeDataTaskMapper() {
        return new AnalyzeDataTaskMapper();
    }

    @Bean
    public UploadDataTaskMapper uploadDataTaskMapper() {
        return new UploadDataTaskMapper();
    }

    @Bean
    public TriggerTaskBuilder scheduledTaskBuilder(AnalyzeDataTaskMapper analyzeDataTaskMapper,
                                                   UploadDataTaskMapper uploadDataTaskMapper,
                                                   CoreFeignClient coreFeignClient) {
        return new TriggerTaskBuilder(analyzeDataTaskMapper,
                uploadDataTaskMapper, coreFeignClient);
    }

    @Bean
    public UploadDataTaskService uploadDataTaskService(UploadDataTaskRepository repository) {
        return new UploadDataTaskServiceImpl(repository);
    }

    @Bean
    public AnalyzeDataTaskService analyzeDataTaskService(AnalyzeDataTaskRepository repository) {
        return new AnalyzeDataTaskServiceImpl(repository);
    }

    @Bean
    public GateProcessor gateProcessor(AnalyzeDataTaskService analyzeDataTaskService,
                                       UploadDataTaskService uploadDataTaskService) {
        return new GateProcessor(analyzeDataTaskService,
                uploadDataTaskService);
    }
}
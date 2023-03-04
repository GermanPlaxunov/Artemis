package org.project.artemisgate.config;

import org.project.artemisgate.task.builder.ScheduledTaskBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public ScheduledTaskBuilder scheduledTaskBuilder() {
        return new ScheduledTaskBuilder();
    }
}

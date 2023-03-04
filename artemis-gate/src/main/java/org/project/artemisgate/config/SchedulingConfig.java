package org.project.artemisgate.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.artemis.artemisdata.polygon.service.interfaces.UploadDataTaskService;
import org.project.artemisgate.task.builder.ScheduledTaskBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class SchedulingConfig implements SchedulingConfigurer {

    private final ScheduledTaskBuilder scheduledTaskBuilder;
    private final UploadDataTaskService uploadDataTaskService;

    @Bean
    public Executor taskExecutor(){
        return Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar){
        taskRegistrar.setScheduler(taskExecutor());
        var enabledTasks = uploadDataTaskService.findAllEnabledTasks();
        for(var enabledTask : enabledTasks){
            var task = scheduledTaskBuilder.buildTriggeredTask(enabledTask);
            taskRegistrar.addTriggerTask(task.getRunnable(), task.getTrigger());
        }
    }
}
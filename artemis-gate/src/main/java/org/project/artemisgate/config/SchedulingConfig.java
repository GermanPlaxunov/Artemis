package org.project.artemisgate.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.artemis.artemisdata.polygon.entities.AnalyzeDataTaskEntity;
import org.artemis.artemisdata.polygon.entities.UploadDataTaskEntity;
import org.artemis.artemisdata.polygon.service.interfaces.AnalyzeDataTaskService;
import org.artemis.artemisdata.polygon.service.interfaces.UploadDataTaskService;
import org.project.artemisgate.task.builder.TriggerTaskBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class SchedulingConfig implements SchedulingConfigurer {

    private final TriggerTaskBuilder triggerTaskBuilder;
    private final UploadDataTaskService uploadDataTaskService;
    private final AnalyzeDataTaskService analyzeDataTaskService;

    @Bean
    public Executor taskExecutor() {
        return Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
        var enabledDataTasks = uploadDataTaskService.findAllEnabledTasks();
        var enabledAnalyzeTasks = analyzeDataTaskService.findAllEnabledTasks();
        var dTasksCount = enabledDataTasks.stream().count();
        var aTasksCount = enabledAnalyzeTasks.stream().count();
        log.info("Data tasks: {}; Analyze tasks: {}", dTasksCount, aTasksCount);
        addAllDataTasksToScheduler(enabledDataTasks, taskRegistrar);
        addAllAnalyzeTasksToScheduler(enabledAnalyzeTasks, taskRegistrar);
    }

    private void addAllDataTasksToScheduler(List<UploadDataTaskEntity> dataTasks,
                                            ScheduledTaskRegistrar taskRegistrar) {
        for (var enabledTask : dataTasks) {
            var task = triggerTaskBuilder.buildTriggeredDataTask(enabledTask);
            taskRegistrar.addTriggerTask(task.getRunnable(), task.getTrigger());
        }
    }

    private void addAllAnalyzeTasksToScheduler(List<AnalyzeDataTaskEntity> analyzeTasks,
                                               ScheduledTaskRegistrar taskRegistrar) {
        for (var enabledTask : analyzeTasks) {
            var task = triggerTaskBuilder.buildTriggeredAnalyzeTask(enabledTask);
            taskRegistrar.addTriggerTask(task.getRunnable(), task.getTrigger());
        }
    }
}
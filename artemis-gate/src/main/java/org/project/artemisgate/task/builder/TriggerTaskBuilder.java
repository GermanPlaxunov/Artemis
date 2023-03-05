package org.project.artemisgate.task.builder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.artemis.artemisdata.polygon.entities.AnalyzeDataTaskEntity;
import org.artemis.artemisdata.polygon.entities.UploadDataTaskEntity;
import org.artemis.artemismodel.task.AnalyzeDataTask;
import org.artemis.artemismodel.task.UploadDataTask;
import org.project.artemisgate.client.CoreClient;
import org.project.artemisgate.task.mapper.AnalyzeDataTaskMapper;
import org.project.artemisgate.task.mapper.UploadDataTaskMapper;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;

import java.time.Instant;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class TriggerTaskBuilder {
    private final AnalyzeDataTaskMapper analyzeDataTaskMapper;
    private final UploadDataTaskMapper uploadDataTaskMapper;
    private final CoreClient client;

    public TriggeredTask buildTriggeredAnalyzeTask(AnalyzeDataTaskEntity entity) {
        var interval = entity.getInterval();
        var task = analyzeDataTaskMapper.map(entity);
        var runnable = createAnalyzeRunnable(task);
        var trigger = createTrigger(interval);
        return new TriggeredTask(runnable, trigger);
    }

    public TriggeredTask buildTriggeredDataTask(UploadDataTaskEntity entity) {
        var interval = entity.getTaskInterval();
        var task = uploadDataTaskMapper.map(entity);
        var runnable = createDataRunnable(task);
        Trigger trigger = createTrigger(interval);
        return new TriggeredTask(runnable, trigger);
    }

    private Trigger createTrigger(long interval) {
        return triggerContext -> {
            var lastExecTime = Optional.ofNullable(triggerContext)
                    .map(TriggerContext::lastActualExecution)
                    .orElse(Instant.now());
            return lastExecTime.plusMillis(interval);
        };
    }

    private Runnable createAnalyzeRunnable(AnalyzeDataTask task) {
        return () -> client.processAnalyzeTask(task);
    }

    private Runnable createDataRunnable(UploadDataTask task) {
        return () -> client.processDataTask(task);
    }
}
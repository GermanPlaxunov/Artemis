package org.project.artemisgate.task.builder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.artemis.artemisdata.polygon.entities.UploadDataTaskEntity;
import org.project.artemisgate.client.CoreClient;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;

import java.time.Instant;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class ScheduledTaskBuilder {

    private final CoreClient client;

    public TriggeredTask buildTriggeredTask(UploadDataTaskEntity entity) {
        var runnable = createRunnable(entity.getSymbol(), entity.getDataInterval());
        Trigger trigger = triggerContext -> {
            var lastExecTime = Optional.ofNullable(triggerContext)
                    .map(TriggerContext::lastActualExecution)
                    .orElse(Instant.now());
            return lastExecTime.plusMillis(entity.getTaskInterval());
        };
        return new TriggeredTask(runnable, trigger);
    }

    private Runnable createRunnable(String symbol, Long dataInterval) {
        return () -> client.processScheduledTask(symbol, dataInterval);
    }
}
package org.project.artemisgate.task.builder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;

import java.time.Instant;
import java.util.Optional;

@Slf4j
public class ScheduledTaskBuilder {

    public TriggeredTask buildTriggeredTask(long interval) {
        Runnable runnable = ()-> log.info("Task launched");
        Trigger trigger = triggerContext -> {
            var lastExecTime = Optional.ofNullable(triggerContext)
                    .map(TriggerContext::lastActualExecution)
                    .orElse(Instant.now());
            return lastExecTime.plusMillis(interval);
        };
        return new TriggeredTask(runnable, trigger);
    }
}

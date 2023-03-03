package org.project.artemisgate.task.builder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;

import java.time.Instant;
import java.util.Optional;

@Slf4j
public class ScheduledTaskBuilder {

    public TriggeredTask buildTriggeredTask(long interval) {
        var runnable = new Runnable() {
            @Override
            public void run() {
                log.info("Task launched");
            }
        };
        var trigger = new Trigger() {
            @Override
            public Instant nextExecution(TriggerContext triggerContext) {
                var lastExecTime = Optional.ofNullable(triggerContext)
                        .map(TriggerContext::lastActualExecution)
                        .orElse(Instant.now());
                var nextExecTime = lastExecTime.plusMillis(interval);
                return nextExecTime;
            }
        };
        return new TriggeredTask(runnable, trigger);
    }
}

package org.project.artemisgate.task.builder;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.Trigger;

@Data
@RequiredArgsConstructor
public class TriggeredTask {
    private final Runnable runnable;
    private final Trigger trigger;
}

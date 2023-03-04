package org.project.artemisgate.client;

public interface CoreClient {

    void processScheduledTask(String symbol, Long interval);
}

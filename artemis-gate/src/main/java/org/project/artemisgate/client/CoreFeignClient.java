package org.project.artemisgate.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "core-client", url = "http://localhost:8081/core")
public interface CoreFeignClient extends CoreClient {

    @Override
    @PostMapping(path = "/processScheduledTask")
    void processScheduledTask(@RequestParam("symbol") String symbol,
                              @RequestParam("interval") Long interval);
}
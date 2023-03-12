package org.project.artemisgate.client;

import org.artemis.artemismodel.task.AnalyzeDataTask;
import org.artemis.artemismodel.task.UploadDataTask;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "core-client", url = "http://localhost:8081/core")
public interface CoreFeignClient extends CoreClient {

    @Override
    @PostMapping(path = "/processDataTask")
    void processDataTask(@RequestBody UploadDataTask uploadDataTask);

    @Override
    @PostMapping(path = "/processAnalyzeTask")
    void processAnalyzeTask(@RequestBody AnalyzeDataTask analyzeDataTask);
}
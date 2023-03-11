package org.project.artemiscore.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.artemis.artemismodel.task.AnalyzeDataTask;
import org.artemis.artemismodel.task.UploadDataTask;
import org.project.artemiscore.core.processor.CoreProcessor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CoreController {

    private final CoreProcessor coreProcessor;

    @PostMapping(path = "/processDataTask")
    public void processDataTask(@RequestBody UploadDataTask uploadDataTask){
        coreProcessor.processDataTask(uploadDataTask);
    }

    @PostMapping(path = "/processAnalyzeTask")
    public void processAnalyzeTask(@RequestBody AnalyzeDataTask analyzeDataTask){
        coreProcessor.processAnalyzeTask(analyzeDataTask);
    }
}

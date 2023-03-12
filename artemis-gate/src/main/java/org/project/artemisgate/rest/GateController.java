package org.project.artemisgate.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.artemis.artemisdata.polygon.dto.AnalyzeTaskDto;
import org.artemis.artemisdata.polygon.dto.DataTaskDto;
import org.project.artemisgate.processor.GateProcessor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GateController {

    private final GateProcessor processor;

    @PostMapping(path = "/addUploadTask")
    public void addUploadTask(@RequestBody DataTaskDto dto) {
        processor.addDataTask(dto);
    }

    @PostMapping(path = "/addAnalyzeTask")
    public void addAnalyzeTask(@RequestBody AnalyzeTaskDto dto) {
        processor.addAnalyzeTask(dto);
    }
}
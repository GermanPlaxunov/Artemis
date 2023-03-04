package org.project.artemisgate.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.artemis.artemisdata.polygon.dto.DataTaskDto;
import org.project.artemisgate.processor.GateProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GateController {

    private final GateProcessor processor;

    @GetMapping(path = "/addUploadTask")
    public void addUploadTask(DataTaskDto dto) {
        processor.addDataTask(dto);
    }

}

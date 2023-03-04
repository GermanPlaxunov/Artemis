package org.project.artemisgate.processor;

import lombok.RequiredArgsConstructor;
import org.artemis.artemisdata.polygon.dto.DataTaskDto;
import org.artemis.artemisdata.polygon.entities.UploadDataTaskEntity;
import org.artemis.artemisdata.polygon.service.interfaces.UploadDataTaskService;

@RequiredArgsConstructor
public class GateProcessor {

    private final UploadDataTaskService uploadDataTaskService;

    public void addDataTask(DataTaskDto dto){
        uploadDataTaskService.save(new UploadDataTaskEntity()
                .setSymbol(dto.getSymbol())
                .setDataInterval(dto.getDataInterval())
                .setTaskInterval(dto.getTaskInterval())
                .setIsEnabled(true));
    }
}
package org.artemis.artemismodel.task;

import lombok.Data;

@Data
public class UploadDataTask {
    private String symbol;
    private Long taskInterval;
    private Long dataInterval;
}
package org.artemis.artemisdata.polygon.dto;

import lombok.Data;

@Data
public class AnalyzeTaskDto {
    private String symbol;
    private Long taskInterval;
    private Boolean enabled;
}

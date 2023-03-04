package org.artemis.artemisdata.polygon.dto;

import lombok.Data;

@Data
public class DataTaskDto {
    private String symbol;
    private Long dataInterval;
    private Long taskInterval;
}

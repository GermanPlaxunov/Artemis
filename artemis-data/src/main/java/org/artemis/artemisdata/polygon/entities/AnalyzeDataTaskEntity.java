package org.artemis.artemisdata.polygon.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "analyze_data_task")
public class AnalyzeDataTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "interval")
    private Long interval;
    @Column(name = "enabled")
    private Boolean enabled;
}
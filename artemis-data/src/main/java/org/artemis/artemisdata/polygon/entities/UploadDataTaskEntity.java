package org.artemis.artemisdata.polygon.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "upload_data_task", schema = "artemis")
public class UploadDataTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "task_interval")
    private Long taskInterval;
    @Column(name = "data_interval")
    private Long dataInterval;
    @Column(name = "enabled")
    private Boolean isEnabled;
}

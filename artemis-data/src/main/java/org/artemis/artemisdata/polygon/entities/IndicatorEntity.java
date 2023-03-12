package org.artemis.artemisdata.polygon.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "market_indicators_values", schema = "artemis")
public class IndicatorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "value")
    private Double value;
    @Column(name = "date")
    private LocalDateTime date;
}

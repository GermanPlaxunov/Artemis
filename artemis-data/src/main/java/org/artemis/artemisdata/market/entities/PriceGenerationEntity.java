package org.artemis.artemisdata.market.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "price_generation", schema = "artemis-gate")
public class PriceGenerationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "trend_speed")
    private Double trendSpeed;
    @Column(name = "is_up_trend")
    private Boolean isUpTrendShort;
    @Column(name = "is_up_trend_long")
    private Boolean isUpTrendLong;
    @Column(name = "date")
    private LocalDateTime date;
}
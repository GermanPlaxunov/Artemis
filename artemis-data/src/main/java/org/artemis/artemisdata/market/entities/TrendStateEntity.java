package org.artemis.artemisdata.market.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "trend_state", schema = "artemis-test")
public class TrendStateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "is_up_trend")
    private Boolean isUpTrendShort;
    @Column(name = "is_up_trend_long")
    private Boolean isUpTrendLong;
    @Column(name = "last_short_trend_change")
    private LocalDateTime lastShortTrendChange;
    @Column(name = "last_long_trend_change")
    private LocalDateTime lastLongTrendChange;
    @Column(name = "short_trend_update_interval")
    private Long shortTrendUpdateInterval;
    @Column(name = "long_trend_update_interval")
    private Long longTrendUpdateInterval;
}

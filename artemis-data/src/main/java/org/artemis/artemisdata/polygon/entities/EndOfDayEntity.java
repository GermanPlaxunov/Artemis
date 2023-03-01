package org.artemis.artemisdata.polygon.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "end_of_day")
public class EndOfDayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "open")
    private Double open;
    @Column(name = "low")
    private Double low;
    @Column(name = "high")
    private Double high;
    @Column(name = "close")
    private Double close;
    @Column(name = "volume")
    private Long volume;
    @Column(name = "weighted_volume")
    private Double weightedVolume;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "transactions_count")
    private Long transactionsCount;
    @Column(name = "otc")
    private Boolean otc;
}
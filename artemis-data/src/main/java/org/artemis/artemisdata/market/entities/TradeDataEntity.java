package org.artemis.artemisdata.market.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "trade_data", schema = "artemis-test")
public class TradeDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
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
    @Column(name = "symbol")
    private String symbol;
}
package org.artemis.artemisdata.market.repositories;

import org.artemis.artemisdata.market.entities.TradeDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TradeDataRepository extends JpaRepository<TradeDataEntity, Long> {
    List<TradeDataEntity> findAllBySymbol(String symbol);
}

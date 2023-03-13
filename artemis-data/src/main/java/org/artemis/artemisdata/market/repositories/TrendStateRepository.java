package org.artemis.artemisdata.market.repositories;

import org.artemis.artemisdata.market.entities.TrendStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TrendStateRepository extends JpaRepository<TrendStateEntity, Long> {
    Optional<TrendStateEntity> findBySymbol(String symbol);

    @Query("update TrendStateEntity entity set entity.lastShortTrendChange = :newDate where entity.symbol = :symbol")
    void updateShortTrendChangeTime(@Param("symbol") String symbol, @Param("newDate") LocalDateTime newDate);

    @Query("update TrendStateEntity entity set entity.lastLongTrendChange = :newDate where entity.symbol = :symbol")
    void updateLongTrendChangeTime(@Param("symbol") String symbol, @Param("newDate") LocalDateTime newDate);

    @Query("update TrendStateEntity entity set entity.isUpTrendShort = not(entity.isUpTrendShort) " +
            "where entity.symbol = :symbol")
    void toggleShortTrend(@Param("symbol") String symbol);

    @Query("update TrendStateEntity entity set entity.isUpTrendLong = not(entity.isUpTrendLong)" +
            "where entity.symbol = :symbol")
    void toggleLongTrend(@Param("symbol") String symbol);

    void deleteAllBySymbol(String symbol);
}

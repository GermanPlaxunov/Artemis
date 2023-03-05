package org.artemis.artemisdata.polygon.repository;

import org.artemis.artemisdata.polygon.entities.AnalyzeDataTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AnalyzeDataTaskRepository extends JpaRepository<AnalyzeDataTaskEntity, Long> {

    Optional<AnalyzeDataTaskEntity> findBySymbol(String symbol);

    List<AnalyzeDataTaskEntity> findAllBySymbolAndEnabled(String symbol, Boolean enabled);

    List<AnalyzeDataTaskEntity> findAllByEnabled(Boolean enabled);

    @Query("update AnalyzeDataTaskEntity entity set entity.enabled = :enabled where entity.symbol = :symbol")
    void toggleBySymbol(@Param("symbol") String symbol, @Param("enabled") Boolean enabled);
}
package org.artemis.artemisdata.polygon.repository;

import org.artemis.artemisdata.polygon.entities.UploadDataTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UploadDataTaskRepository extends
        JpaRepository<UploadDataTaskEntity, Long> {

    Optional<UploadDataTaskEntity> findBySymbolAndIsEnabled(String symbol, Boolean isEnabled);

    List<UploadDataTaskEntity> findAllByIsEnabled(Boolean isEnabled);

    @Query("update UploadDataTaskEntity entity set entity.isEnabled = :enabled where entity.symbol = :symbol")
    void toggleTask(@Param("symbol") String symbol, @Param("enabled") Boolean enabled);
}

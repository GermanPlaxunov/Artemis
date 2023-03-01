package org.artemis.artemisdata.polygon.repository;

import org.artemis.artemisdata.polygon.entities.EndOfDayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EndOfDayRepository extends JpaRepository<EndOfDayEntity, Long> {
    List<EndOfDayEntity> findAllBySymbol(String symbol);
}

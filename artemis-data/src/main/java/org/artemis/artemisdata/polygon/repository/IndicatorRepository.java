package org.artemis.artemisdata.polygon.repository;

import org.artemis.artemisdata.polygon.entities.IndicatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IndicatorRepository extends JpaRepository<IndicatorEntity, Long> {

    Optional<IndicatorEntity> findByNameAndSymbol(String name, String Symbol);
}
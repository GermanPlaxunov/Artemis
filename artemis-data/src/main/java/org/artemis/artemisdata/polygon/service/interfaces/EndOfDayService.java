package org.artemis.artemisdata.polygon.service.interfaces;

import org.artemis.artemisdata.polygon.entities.EndOfDayEntity;

import java.util.List;

public interface EndOfDayService {
    void save(EndOfDayEntity entity);
    void saveAll(List<EndOfDayEntity> entities);
    List<EndOfDayEntity> getAllBySymbol(String symbol);
    void delete(Long id);
}

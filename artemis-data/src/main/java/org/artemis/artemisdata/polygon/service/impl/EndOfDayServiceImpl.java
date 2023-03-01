package org.artemis.artemisdata.polygon.service.impl;

import lombok.RequiredArgsConstructor;
import org.artemis.artemisdata.polygon.entities.EndOfDayEntity;
import org.artemis.artemisdata.polygon.repository.EndOfDayRepository;
import org.artemis.artemisdata.polygon.service.interfaces.EndOfDayService;

import java.util.List;

@RequiredArgsConstructor
public class EndOfDayServiceImpl implements EndOfDayService {
    private final EndOfDayRepository repository;

    @Override
    public void save(EndOfDayEntity entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public void saveAll(List<EndOfDayEntity> entities) {
        repository.saveAllAndFlush(entities);
    }

    @Override
    public List<EndOfDayEntity> getAllBySymbol(String symbol) {
        return repository.findAllBySymbol(symbol);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

package org.artemis.artemisdata.market.service.classes;

import lombok.RequiredArgsConstructor;
import org.artemis.artemisdata.market.entities.TradeDataEntity;
import org.artemis.artemisdata.market.repositories.TradeDataRepository;
import org.artemis.artemisdata.market.service.interfaces.TradeDataService;

import java.util.List;

@RequiredArgsConstructor
public class TradeDataServiceImpl implements TradeDataService {

    private final TradeDataRepository repository;

    @Override
    public void save(TradeDataEntity entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public void saveAll(List<TradeDataEntity> entities) {
        repository.saveAllAndFlush(entities);
    }

    @Override
    public List<TradeDataEntity> findAllBySymbol(String symbol) {
        return repository.findAllBySymbol(symbol);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        repository.deleteAllById(ids);
    }
}

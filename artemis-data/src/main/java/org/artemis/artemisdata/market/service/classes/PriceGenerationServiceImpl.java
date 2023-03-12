package org.artemis.artemisdata.market.service.classes;

import lombok.RequiredArgsConstructor;
import org.artemis.artemisdata.market.entities.PriceGenerationEntity;
import org.artemis.artemisdata.market.repositories.PriceGenerationRepository;
import org.artemis.artemisdata.market.service.interfaces.PriceGenerationService;

import java.util.List;

@RequiredArgsConstructor
public class PriceGenerationServiceImpl implements PriceGenerationService {

    private final PriceGenerationRepository repository;

    @Override
    public void save(PriceGenerationEntity entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public void saveAll(List<PriceGenerationEntity> entities) {
        repository.saveAllAndFlush(entities);
    }

    @Override
    public List<PriceGenerationEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<PriceGenerationEntity> findAllBySymbol(String symbol) {
        return repository.findAllBySymbolOOrderByDateDesc(symbol);
    }

    @Override
    public void delete(PriceGenerationEntity entity) {
        repository.delete(entity);
    }
}

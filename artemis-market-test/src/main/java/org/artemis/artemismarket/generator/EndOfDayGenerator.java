package org.artemis.artemismarket.generator;

import org.artemis.artemisdata.polygon.entities.EndOfDayEntity;

public class EndOfDayGenerator {

    public EndOfDayEntity generate(EndOfDayGenerationData data) {
        return new EndOfDayEntity()
                .setSymbol(data.getSymbol());
    }

}

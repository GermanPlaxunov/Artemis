package org.project.artemiscore.core.processor.data;

import lombok.RequiredArgsConstructor;
import org.artemis.artemisdata.polygon.entities.EndOfDayEntity;

import java.util.List;

@RequiredArgsConstructor
public class DataCompletenessVerifier {

    private final DataGapsCheck dataGapsCheck;

    public boolean checkIfDataIsComplete(List<EndOfDayEntity> eod) {
        return dataGapsCheck.isDataContainsGaps(eod);
    }

}

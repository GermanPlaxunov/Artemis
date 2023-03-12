package org.project.artemiscore.core.processor.data;

import lombok.RequiredArgsConstructor;
import org.artemis.artemisdata.polygon.entities.EndOfDayEntity;
import org.project.artemiscore.core.processor.data.date.DateGapsCheck;

import java.util.List;

@RequiredArgsConstructor
public class DataGapsCheck {

    private final DateGapsCheck dateGapsCheck;

    public boolean isDataContainsGaps(List<EndOfDayEntity> eods) {
        var dates = eods.stream()
                .map(eod -> eod.getDate())
                .toList();
        return dateGapsCheck.ifDatesContainsDayGap(dates);
    }

}

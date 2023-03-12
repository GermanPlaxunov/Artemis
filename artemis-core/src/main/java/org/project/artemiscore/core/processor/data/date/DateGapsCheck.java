package org.project.artemiscore.core.processor.data.date;

import java.time.LocalDateTime;
import java.util.List;

public class DateGapsCheck {

    public boolean ifDatesContainsDayGap(List<LocalDateTime> dates) {
        for (var i = 0; i < dates.size() - 1; i++) {
            var from = dates.get(i);
            var to = dates.get(i + 1);
            if (ifDayGapBetweenDates(from, to)) {
                return true;
            }
        }
        return false;
    }

    private boolean ifDayGapBetweenDates(LocalDateTime from, LocalDateTime to) {
        return from.toLocalDate()
                .datesUntil(to.toLocalDate())
                .count() > 0;
    }

}

package org.artemis.artemiscommon.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String convertLocalDateTimeToString(LocalDateTime date) {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return formatter.format(date);
    }
}

package org.artemis.artemiscommon.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String convertLocalDateTimeToString(LocalDateTime date) {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return formatter.format(date);
    }

    public static LocalDateTime getLdtFromMills(Long mills) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZoneId.systemDefault());
    }
}

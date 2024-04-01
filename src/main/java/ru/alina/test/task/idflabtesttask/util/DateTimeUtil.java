package ru.alina.test.task.idflabtesttask.util;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class DateTimeUtil {
    public static OffsetDateTime getStartNextMonth(OffsetDateTime dateTime) {
        OffsetDateTime nextMonth = dateTime.plusMonths(1);
        return OffsetDateTime.of(nextMonth.getYear(), nextMonth.getMonthValue(), 1, 0, 0, 0, 0, ZoneOffset.UTC);
    }

    public static OffsetDateTime getStartMonth(OffsetDateTime dateTime) {
        return OffsetDateTime.of(dateTime.getYear(), dateTime.getMonthValue(), 1, 0, 0, 0, 0, ZoneOffset.UTC);
    }
}

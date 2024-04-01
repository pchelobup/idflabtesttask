package ru.alina.test.task.idflabtesttask;

import ru.alina.test.task.idflabtesttask.model.Limit;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class LimitData {
    public static ZoneOffset ZONE_OFFSET = ZoneOffset.of("+02:00");
    public static Limit LIMIT_1 = new Limit(1L, LimitCategory.PRODUCT, OffsetDateTime.of(2024, 1, 1, 10, 0, 0, 0, ZoneOffset.UTC), new BigDecimal("1000"));
    public static Limit LIMIT_2 = new Limit(2L, LimitCategory.SERVICE, OffsetDateTime.of(2024, 1, 1, 10, 0, 0, 0, ZoneOffset.UTC), new BigDecimal("1000"));
    public static Limit LIMIT_3 = new Limit(3L, LimitCategory.PRODUCT, OffsetDateTime.of(2024, 1, 1, 10, 0, 0, 0, ZoneOffset.UTC), new BigDecimal("5000"));
    public static Limit LIMIT_4 = new Limit(4L, LimitCategory.PRODUCT, OffsetDateTime.of(2024, 1, 1, 10, 0, 0, 0, ZoneOffset.UTC), new BigDecimal("1000"));
    public static Limit LIMIT_5 = new Limit(5L, LimitCategory.SERVICE,OffsetDateTime.of(2024, 1, 1, 10, 0, 0, 0, ZoneOffset.UTC), new BigDecimal("1000"));
    public static Limit LIMIT_6 = new Limit(6L, LimitCategory.PRODUCT, OffsetDateTime.of(2024, 1, 1, 10, 0, 0, 0, ZoneOffset.UTC), new BigDecimal("400"));

    public static List<Limit> LIMITS = List.of(LIMIT_1, LIMIT_2, LIMIT_3, LIMIT_4, LIMIT_5, LIMIT_6);

    public static OffsetDateTime D_APRIL_START = OffsetDateTime.of(2024, 1, 1, 10, 0, 0, 0, ZoneOffset.UTC);
    public static OffsetDateTime D_FEBRUARY_MIDDLE = OffsetDateTime.of(2024, 2, 20, 0, 0, 0, 0, ZoneOffset.UTC);

    public static Limit created = new Limit(null, LimitCategory.SERVICE, OffsetDateTime.of(2024, 1, 1, 10, 0, 0, 0, ZoneOffset.UTC), new BigDecimal("1000"));

    public static Limit getNew() {
        return new Limit(null, LimitCategory.PRODUCT, OffsetDateTime.of(2024, 1, 1, 10, 0, 0, 0, ZoneOffset.UTC), new BigDecimal("5000"));
    }

    public static Limit getNewWithNegativeLimit() {
        return new Limit(null, LimitCategory.PRODUCT, OffsetDateTime.of(2024, 1, 1, 10, 0, 0, 0, ZoneOffset.UTC), new BigDecimal("-5000"));
    }
}

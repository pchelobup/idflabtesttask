package ru.alina.test.task.idflabtesttask.service;

//todo проверить в один день но в разное время

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.alina.test.task.idflabtesttask.Matcher;
import ru.alina.test.task.idflabtesttask.model.Limit;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.alina.test.task.idflabtesttask.LimitData.*;

class LimitServiceTest extends ServiceTest {
    @Autowired
    LimitService service;


    @Test
    void getMonthLimit() {
        Limit actual = service.getMonthLimit(LimitCategory.PRODUCT, D_APRIL_START, ZONE_OFFSET);
        Matcher.match(actual, LIMIT_1);
    }

    @Test
    void getMonthLimit2() {
        Limit actual = service.getMonthLimit(LimitCategory.PRODUCT, D_FEBRUARY_MIDDLE, ZONE_OFFSET);
        Matcher.match(actual, LIMIT_6, "date");
    }

    @Test
    void getMonthLimitCreated() {
        Limit actual = service.getMonthLimit(LimitCategory.SERVICE, D_APRIL_START, ZONE_OFFSET);
        Matcher.match(actual, created, "id","datetime");
    }

    @Test
    void getAll() {
        Matcher.match(service.getAll(), LIMITS);
    }

    @Test
    void save() {
        Limit created = service.save(getNew());
        Limit expected = getNew();
        expected.setId(created.getId());
        Matcher.match(created, expected);
    }

    @Test
    void saveNegativeLimit() {
        Limit created = service.save(getNewWithNegativeLimit());
        Assertions.assertEquals(created.getSum(), new BigDecimal("1000"));

    }

    @Test
    void update() {
        assertThrows(IllegalArgumentException.class, ()-> service.save(LIMIT_1));
    }
}
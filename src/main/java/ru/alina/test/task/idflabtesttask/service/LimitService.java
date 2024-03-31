package ru.alina.test.task.idflabtesttask.service;

import ru.alina.test.task.idflabtesttask.model.Limit;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

public interface LimitService {
    Limit getMonthLimit(LimitCategory category, LocalDateTime date, ZoneOffset zoneOffset);

    List<Limit> getAll();

    Limit save(Limit limit);

}

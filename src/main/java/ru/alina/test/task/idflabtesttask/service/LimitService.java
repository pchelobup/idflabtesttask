package ru.alina.test.task.idflabtesttask.service;

import ru.alina.test.task.idflabtesttask.model.Limit;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;

import java.time.OffsetDateTime;
import java.util.List;

public interface LimitService {
    Limit getMonthLimit(LimitCategory category, OffsetDateTime dateTime);

    List<Limit> getAll();

    Limit save(Limit limit);

}

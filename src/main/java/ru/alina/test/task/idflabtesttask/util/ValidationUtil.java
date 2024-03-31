package ru.alina.test.task.idflabtesttask.util;

import ru.alina.test.task.idflabtesttask.model.BaseEntity;

public class ValidationUtil {
    public static void checkNew(BaseEntity entity) {
        if (!entity.isNew()) {
            throw new IllegalArgumentException(entity + " must be new");
        }
    }
}

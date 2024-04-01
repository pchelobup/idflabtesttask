package ru.alina.test.task.idflabtesttask.mapper;

import org.mapstruct.*;
import ru.alina.test.task.idflabtesttask.model.Limit;
import ru.alina.test.task.idflabtesttask.to.LimitToRequest;
import ru.alina.test.task.idflabtesttask.to.LimitToResponse;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.SETTER)
public interface LimitMapper {

    Limit requstLimitToLimit(LimitToRequest limitTo);

    LimitToResponse limitToResponse(Limit limit);


}

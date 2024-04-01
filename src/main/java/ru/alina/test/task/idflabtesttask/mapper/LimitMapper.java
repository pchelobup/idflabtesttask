package ru.alina.test.task.idflabtesttask.mapper;

import org.mapstruct.*;
import ru.alina.test.task.idflabtesttask.model.Limit;
import ru.alina.test.task.idflabtesttask.to.LimitToRequest;
import ru.alina.test.task.idflabtesttask.to.LimitToResponse;

import java.time.OffsetDateTime;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.SETTER)
public interface LimitMapper {

    Limit requstLimitToLimit(LimitToRequest limitTo);

    @Mapping(source = "dateTime", target = "localDateTime")
    LimitToResponse limitToResponse(Limit limit);

    @AfterMapping
    default void initLimit(@MappingTarget Limit limit) {
        OffsetDateTime offsetDateTime = OffsetDateTime.now().withOffsetSameInstant(limit.getZoneOffset());
        limit.setDateTime(offsetDateTime.toLocalDateTime());
    }

    @AfterMapping
    default void initLimitToResponse(@MappingTarget LimitToResponse limitTo) {
        OffsetDateTime offsetDateTime = limitTo.getLocalDateTime().atOffset(limitTo.getZoneOffset());
        limitTo.setDatetime(offsetDateTime);
    }

}

package ru.alina.test.task.idflabtesttask.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ru.alina.test.task.idflabtesttask.model.Transaction;
import ru.alina.test.task.idflabtesttask.to.TransactionExceededLimitTo;
import ru.alina.test.task.idflabtesttask.to.TransactionTo;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(source = "localDateTime", target = "datetime")
    Transaction toToTransaction(TransactionTo transactionTo);

    @Mapping(source = "datetime", target = "localDateTime")
    @Mapping(source = "limit.sum", target = "limitSum")
    @Mapping(source = "limit.zoneOffset", target = "limitZoneOffset")
    @Mapping(source = "limit.dateTime", target = "limitLocalDateTime")
    TransactionExceededLimitTo limitExceededToToTransaction(Transaction transaction);

    @AfterMapping
    default void initTransactionExceededLimitTo(@MappingTarget TransactionExceededLimitTo transactionExceededLimitTo) {
        transactionExceededLimitTo.setDateTime(transactionExceededLimitTo.getLocalDateTime().atOffset(transactionExceededLimitTo.getZoneOffset()));
        transactionExceededLimitTo.setLimitDatetime(transactionExceededLimitTo.getLimitLocalDateTime().atOffset(transactionExceededLimitTo.getLimitZoneOffset()));
    }


}

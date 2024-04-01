package ru.alina.test.task.idflabtesttask.mapper;

import org.mapstruct.*;
import ru.alina.test.task.idflabtesttask.model.Transaction;
import ru.alina.test.task.idflabtesttask.to.TransactionExceededLimitTo;
import ru.alina.test.task.idflabtesttask.to.TransactionTo;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TransactionMapper {

    Transaction toToTransaction(TransactionTo transactionTo);


    @Mapping(source = "limit.sum", target = "limitSum")
    @Mapping(source = "limit.datetime", target = "limitDatetime")
    TransactionExceededLimitTo limitExceededToToTransaction(Transaction transaction);

    @AfterMapping
    default void initTransactionExceededLimitTo(@MappingTarget TransactionExceededLimitTo transactionExceededLimitTo, Transaction transaction) {
        transactionExceededLimitTo.setDatetime(transaction.getDatetime().withOffsetSameInstant(transaction.getZoneOffset()));
    }

    @AfterMapping
    default void initTransaction(@MappingTarget Transaction transaction, TransactionTo transactionTo) {
        transaction.setZoneOffset(transactionTo.getDatetime().getOffset());
    }


}

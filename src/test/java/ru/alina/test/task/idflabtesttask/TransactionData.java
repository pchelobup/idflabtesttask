package ru.alina.test.task.idflabtesttask;

import ru.alina.test.task.idflabtesttask.model.Currency;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;
import ru.alina.test.task.idflabtesttask.model.Transaction;

import java.math.BigDecimal;
import java.time.*;
import java.util.List;

public class TransactionData {
    public static ZoneOffset ZONE_OFFSET = ZoneOffset.of("+02:00");
    public static Transaction TRANSACTION_2 = new Transaction(2L, 1111111111, 2222222222L, Currency.RUB, new BigDecimal("220000.00"), new BigDecimal("2200.00"), LimitCategory.PRODUCT, LocalDateTime.of(2024, 1, 7, 10, 0), ZONE_OFFSET, true);
    public static Transaction TRANSACTION_4 = new Transaction(4L, 1111111111, 2222222222L, Currency.RUB, new BigDecimal("39900.00"), new BigDecimal("399.00"), LimitCategory.PRODUCT, LocalDateTime.of(2024, 2, 1, 10, 0), ZONE_OFFSET, false);
    public static Transaction TRANSACTION_5 = new Transaction(5L, 1111111111, 2222222222L, Currency.RUB, new BigDecimal("200.00"), new BigDecimal("2.2"), LimitCategory.PRODUCT, LocalDateTime.of(2024, 2, 12, 10, 0), ZONE_OFFSET, true);

    public static List<Transaction> getTransactionsLimitExceeded() {
        TRANSACTION_5.setLimit(LimitData.LIMIT_4);
        TRANSACTION_2.setLimit(LimitData.LIMIT_1);
        return List.of(TRANSACTION_5, TRANSACTION_2);
    }


    public static List<Transaction> TRANSACTIONS_PRODUCT_FEBRUARY = List.of(TRANSACTION_4, TRANSACTION_5);

    public static Transaction getNewLimitExceededFalse() {
        Transaction transaction = new Transaction(null, 1111111111, 2222222222L, Currency.RUB, new BigDecimal("1"), new BigDecimal("0.01081"), LimitCategory.SERVICE, LocalDateTime.of(2024, 2, 14, 11, 0), ZONE_OFFSET, null);
        transaction.setLimit(LimitData.LIMIT_5);
        return transaction;
    }

    public static Transaction getNewLimitExceededTrue() {
        Transaction transaction = new Transaction(null, 1111111111, 2222222222L, Currency.RUB, new BigDecimal("20200"), new BigDecimal("218.36200"), LimitCategory.PRODUCT, LocalDateTime.of(2024, 2, 14, 11, 0), ZONE_OFFSET, null);
        transaction.setLimit(LimitData.LIMIT_6);
        return transaction;
    }
}

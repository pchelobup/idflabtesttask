package ru.alina.test.task.idflabtesttask.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.alina.test.task.idflabtesttask.Matcher;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;
import ru.alina.test.task.idflabtesttask.model.Transaction;

import static ru.alina.test.task.idflabtesttask.TransactionData.*;

class TransactionServiceTest extends ServiceTest {
    @Autowired
    TransactionService service;

    @Test
    void getExceededLimitTransactions() {
        Matcher.match(service.getExceededLimitTransactions(), getTransactionsLimitExceeded(), "datetime", "limit.date");
    }

    @Test
    void saveExceededFalse() {
        Transaction created = service.save(getNewLimitExceededFalse());
        Transaction expected = getNewLimitExceededFalse();
        expected.setId(created.getId());
        expected.setLimitExceeded(false);
        Matcher.match(created, expected, "limit.date");
    }

    @Test
    void saveExceededTrue() {
        Transaction created = service.save(getNewLimitExceededTrue());
        Transaction expected = getNewLimitExceededTrue();
        expected.setId(created.getId());
        expected.setLimitExceeded(true);
        Matcher.match(created, expected, "limit.date");
    }

    @Test
    void getAllInMonth() {
        Matcher.match(service.getAllInMonth(LimitCategory.PRODUCT, TRANSACTION_5.getDatetime()), TRANSACTIONS_PRODUCT_FEBRUARY, "limit", "datetime");
    }
}
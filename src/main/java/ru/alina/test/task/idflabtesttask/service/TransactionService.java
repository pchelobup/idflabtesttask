package ru.alina.test.task.idflabtesttask.service;

import ru.alina.test.task.idflabtesttask.model.LimitCategory;
import ru.alina.test.task.idflabtesttask.model.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionService {
    List<Transaction> getExceededLimitTransactions();

    Transaction save(Transaction transaction);

    List<Transaction> getAllInMonth(LimitCategory category, LocalDateTime dateTo);

}

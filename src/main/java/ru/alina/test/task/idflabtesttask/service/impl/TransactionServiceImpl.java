package ru.alina.test.task.idflabtesttask.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alina.test.task.idflabtesttask.model.Currency;
import ru.alina.test.task.idflabtesttask.model.Limit;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;
import ru.alina.test.task.idflabtesttask.model.Transaction;
import ru.alina.test.task.idflabtesttask.repository.TransactionRepository;
import ru.alina.test.task.idflabtesttask.service.ExchangeRateService;
import ru.alina.test.task.idflabtesttask.service.LimitService;
import ru.alina.test.task.idflabtesttask.service.TransactionService;
import ru.alina.test.task.idflabtesttask.util.TransactionUtil;

import java.math.BigDecimal;
import java.time.*;
import java.util.Date;
import java.util.List;

import static ru.alina.test.task.idflabtesttask.util.TransactionUtil.getSumMonthTransactions;

@Service
@Transactional(readOnly = true)
public class TransactionServiceImpl implements TransactionService {
    private static final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);
    private TransactionRepository repository;
    private LimitService limitService;
    private ExchangeRateService exchangeRatesService;

    public TransactionServiceImpl(TransactionRepository repository, LimitService limitService, ExchangeRateService exchangeRatesService) {
        this.repository = repository;
        this.limitService = limitService;
        this.exchangeRatesService = exchangeRatesService;
    }

    @Override
    public List<Transaction> getExceededLimitTransactions() {
        List<Transaction> transactions = repository.getExceededLimitTransactions(true);
        log.info("get {} exceededTransactions", transactions.size());
        return transactions;
    }

    /**
     * устанавливается флаг exceed
     * ковертируется сумма в валюиу
     *
     * @param transaction
     */

    @Override
    @Transactional
    public Transaction save(Transaction transaction) {
        Limit limit = limitService.getMonthLimit(transaction.getExpenseCategory(), transaction.getDatetime(), transaction.getZoneOffset());
        if (limit == null) {
            limit = limitService.save(new Limit(transaction.getExpenseCategory(), transaction.getZoneOffset()));
        }

        //setLimit
        transaction.setLimit(limit);
        BigDecimal limitSum = transaction.getLimit().getSum();

        //set sum in USDT
        if (transaction.getCurrency().equals(Currency.USD)) {
            transaction.setSumUSD(transaction.getSum());
        } else {
            BigDecimal rate = exchangeRatesService.getExchangeRate(Date.from(transaction.getDatetime().toInstant(ZoneOffset.UTC)), transaction.getCurrency()).getClose();
            BigDecimal sumInDollars = TransactionUtil.convertToUsd(transaction.getSum(), transaction.getCurrency(), rate);
            transaction.setSumUSD(sumInDollars);

        }

        //получить лимит в доллраха
        List<Transaction> transactions = getAllInMonth(transaction.getExpenseCategory(), transaction.getDatetime());
        BigDecimal sumTr = getSumMonthTransactions(transactions).add(transaction.getSumUSD());

        if (limitSum.compareTo(sumTr) >= 0) {
            transaction.setLimitExceeded(false);
        } else {
            transaction.setLimitExceeded(true);
        }
        log.info("create {}", transaction);
        return repository.save(transaction);
    }


    @Override
    public List<Transaction> getAllInMonth(LimitCategory category, LocalDateTime dateTo) {
        LocalDateTime dateFrom = LocalDateTime.of(dateTo.getYear(), dateTo.getMonth(), 1, 0, 0);
        log.info("find transactions for {} category in {} month", category, dateTo.getMonth());
        return repository.findAllByDatetime(category, dateFrom, dateTo);
    }


}

package ru.alina.test.task.idflabtesttask.util;

import ru.alina.test.task.idflabtesttask.model.Currency;
import ru.alina.test.task.idflabtesttask.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public class TransactionUtil {
    /**
     *
     * @param transactions транзакции
     * @return сумму транзакций в доллорах
     */
    public static BigDecimal getSumMonthTransactions(List<Transaction> transactions) {
        BigDecimal result = new BigDecimal(0);
        for (Transaction t : transactions) {
            result = result.add(t.getSumUSD());
        }
        return result;
    }

    public static BigDecimal convertToUsd(BigDecimal sum, Currency currency, BigDecimal rate) {
        if (currency.equals(Currency.USD)) return sum;

        return sum.multiply(rate);
    }
}

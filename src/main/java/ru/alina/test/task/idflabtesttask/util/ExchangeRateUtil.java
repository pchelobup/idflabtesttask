package ru.alina.test.task.idflabtesttask.util;

import ru.alina.test.task.idflabtesttask.model.Currency;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class ExchangeRateUtil {


    /**
     * @param currency валюта
     * @return строковаое представление валбтной пары USD/currency
     */
    public static String getCurrencyPair(Currency currency) {
        if (currency.equals(Currency.KZT)) {
            return Currency.USD.name() + "/" + currency.name();
        }
        return currency.name() + "/" + Currency.USD.name();
    }

    public static BigDecimal reverseRate(BigDecimal close) {
        return new BigDecimal("1")
                .divide(close.setScale(5, RoundingMode.HALF_DOWN), 5, RoundingMode.HALF_DOWN);
    }
}

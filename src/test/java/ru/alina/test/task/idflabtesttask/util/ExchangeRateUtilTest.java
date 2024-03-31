package ru.alina.test.task.idflabtesttask.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.alina.test.task.idflabtesttask.ExchangeRateData;
import ru.alina.test.task.idflabtesttask.model.Currency;

class ExchangeRateUtilTest {

    @Test
    void getCurrencyPairRub() {
        Assertions.assertEquals(ExchangeRateUtil.getCurrencyPair(Currency.RUB), ExchangeRateData.USD_RUB);
    }

    @Test
    void getCurrencyPairKzt() {
        Assertions.assertEquals(ExchangeRateUtil.getCurrencyPair(Currency.KZT), ExchangeRateData.KZT_USD);
    }
}
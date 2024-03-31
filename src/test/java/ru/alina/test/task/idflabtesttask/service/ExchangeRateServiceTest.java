package ru.alina.test.task.idflabtesttask.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.alina.test.task.idflabtesttask.ExchangeRateData;
import ru.alina.test.task.idflabtesttask.Matcher;
import ru.alina.test.task.idflabtesttask.model.Currency;
import ru.alina.test.task.idflabtesttask.model.ExchangeRate;
import ru.alina.test.task.idflabtesttask.repository.ExchangeRateRepository;


import static ru.alina.test.task.idflabtesttask.ExchangeRateData.*;


class ExchangeRateServiceTest extends ServiceTest {
    @Autowired
    ExchangeRateService service;
    @Autowired
    ExchangeRateRepository repository;

    @Test
    void getRate() {
        ExchangeRate rate = service.getExchangeRate(ExchangeRateData.EXCHANGE_RATE_1.getDate(), ExchangeRateData.EXCHANGE_RATE_1.getCurrency());
        Matcher.match(ExchangeRateData.EXCHANGE_RATE_1, rate, "date");
        Assertions.assertEquals(repository.findAll().size(), EXCHANGE_SIZE);
    }

    @Test
    void getRateNotEqual() {
        ExchangeRate rate = service.getExchangeRate(ExchangeRateData.EXCHANGE_RATE_2.getDate(), ExchangeRateData.EXCHANGE_RATE_2.getCurrency());
        Matcher.notMatch(rate, ExchangeRateData.EXCHANGE_RATE_1, "date");
        Assertions.assertEquals(repository.findAll().size(), EXCHANGE_SIZE);
    }

    @Test
    void getRateNotExist() {
        ExchangeRate created = service.getExchangeRate(DATE_NEW, Currency.RUB);
        Assertions.assertEquals(created.getCurrency(), Currency.RUB);
        Assertions.assertEquals(repository.findAll().size(), EXCHANGE_SIZE + 1);
    }

    @Test
    void getRateNotExistSaneDataAnotherCurrency() {
        ExchangeRate createdKzt = service.getExchangeRate(EXCHANGE_RATE_1_DUPLICATE_KZT.getDate(), Currency.KZT);
        Assertions.assertEquals(createdKzt.getCurrency(), Currency.KZT);

        ExchangeRate created = service.getExchangeRate(DATE_NEW, Currency.RUB);
        Assertions.assertEquals(created.getCurrency(), Currency.RUB);

        Assertions.assertEquals(repository.findAll().size(), EXCHANGE_SIZE + 2);
    }

}
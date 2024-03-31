package ru.alina.test.task.idflabtesttask.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alina.test.task.idflabtesttask.model.Currency;
import ru.alina.test.task.idflabtesttask.model.ExchangeRate;
import ru.alina.test.task.idflabtesttask.repository.ExchangeRateRepository;
import ru.alina.test.task.idflabtesttask.service.ExchangeRateService;
import ru.alina.test.task.idflabtesttask.util.ExchangeRateUtil;
import ru.alina.test.task.idflabtesttask.web.client.ExchangeRatesClientService;

import java.util.Date;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
    private final ExchangeRateRepository repository;

    private final ExchangeRatesClientService exchangeRatesClientService;

    public ExchangeRateServiceImpl(ExchangeRateRepository repository, ExchangeRatesClientService exchangeRatesClientService) {
        this.repository = repository;
        this.exchangeRatesClientService = exchangeRatesClientService;
    }

    @Override
    @Transactional
    public ExchangeRate getExchangeRate(Date date, Currency currency) {
        ExchangeRate exchangeRate = repository.findExchangeRateByDateAndCurrency(date, currency);
        if (exchangeRate == null) {
            ExchangeRate exchangeRateNew = exchangeRatesClientService.getExchangeRates(date, currency);
            if (currency.equals(Currency.KZT)) {
                exchangeRateNew.setClose(ExchangeRateUtil.reverseRate(exchangeRateNew.getClose()));
            }
            exchangeRate = repository.save(exchangeRateNew);

        }
        return exchangeRate;
    }
}

package ru.alina.test.task.idflabtesttask.service;

import ru.alina.test.task.idflabtesttask.model.Currency;
import ru.alina.test.task.idflabtesttask.model.ExchangeRate;

import java.util.Date;

public interface ExchangeRateService {
    ExchangeRate getExchangeRate(Date date, Currency currency);

}

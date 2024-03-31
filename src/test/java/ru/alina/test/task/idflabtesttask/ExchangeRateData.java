package ru.alina.test.task.idflabtesttask;

import ru.alina.test.task.idflabtesttask.model.Currency;
import ru.alina.test.task.idflabtesttask.model.ExchangeRate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

public class ExchangeRateData {
    public static int EXCHANGE_SIZE = 5;
    public static ExchangeRate EXCHANGE_RATE_1 = new ExchangeRate(1L, Date.from(LocalDate.of(2024, 1, 1).atStartOfDay().toInstant(ZoneOffset.UTC)), Currency.RUB, new BigDecimal("0.01115"));
    public static ExchangeRate EXCHANGE_RATE_2 = new ExchangeRate(2L, Date.from(LocalDate.of(2024, 1, 8).atStartOfDay().toInstant((ZoneOffset.UTC))), Currency.RUB, new BigDecimal("0.01115"));

    public static Date DATE_NEW = Date.from(LocalDate.of(2024, 3, 29).atStartOfDay().toInstant(ZoneOffset.UTC));

    public static ExchangeRate EXCHANGE_RATE_1_DUPLICATE_KZT = new ExchangeRate(null, EXCHANGE_RATE_1.getDate(), Currency.KZT, new BigDecimal("0.01085"));

    public static String USD_RUB = Currency.RUB + "/" + Currency.USD;
    public static String KZT_USD = Currency.USD + "/" + Currency.KZT;

}

package ru.alina.test.task.idflabtesttask.exception;

public class ExchangeRateClientException extends RuntimeException {
    public ExchangeRateClientException() {
        super("can not get exchange rate");
    }
}

package ru.alina.test.task.idflabtesttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.alina.test.task.idflabtesttask.model.Currency;
import ru.alina.test.task.idflabtesttask.model.ExchangeRate;

import java.util.Date;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    @Query("SELECT r from ExchangeRate r where r.date=:date and r.currency=:currency")
    ExchangeRate findExchangeRateByDateAndCurrency(Date date, Currency currency);
}

package ru.alina.test.task.idflabtesttask.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "exchange_rates")
public class ExchangeRate extends BaseEntity {

    @Column(name = "date_exchange_rate")
    private Date date;

    @Column(name = "currency_shortname")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(name = "value_rate")
    private BigDecimal close;

    public ExchangeRate() {
    }

    public ExchangeRate(Date date, Currency currency, BigDecimal close) {
        this.date = date;
        this.currency = currency;
        this.close = close;
    }

    public ExchangeRate(Long id, Date date, Currency currency, BigDecimal close) {
        super(id);
        this.date = date;
        this.currency = currency;
        this.close = close;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "date=" + date +
                ", currency=" + currency +
                ", rate=" + close +
                ", id=" + id +
                '}';
    }
}

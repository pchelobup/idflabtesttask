package ru.alina.test.task.idflabtesttask.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "exchange_rates")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class ExchangeRate extends BaseEntity {

    @Column(name = "date_exchange_rate")
    private Date date;

    @Column(name = "currency_shortname")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(name = "value_rate")
    private BigDecimal close;

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
}

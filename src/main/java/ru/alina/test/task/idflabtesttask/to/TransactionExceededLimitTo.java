package ru.alina.test.task.idflabtesttask.to;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import ru.alina.test.task.idflabtesttask.model.Currency;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Component
@Getter
@Setter
@ToString
public class TransactionExceededLimitTo {
    private long accountFrom;
    private long accountTo;
    private Currency currency;
    private BigDecimal sum;
    private LimitCategory expenseCategory;
    private OffsetDateTime datetime;

    private BigDecimal limitSum;

    private OffsetDateTime limitDatetime;


    private Currency limitCurrency;

    public TransactionExceededLimitTo() {
        this.limitCurrency = Currency.USD;
    }


}

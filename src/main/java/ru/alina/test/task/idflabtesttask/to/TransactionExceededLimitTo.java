package ru.alina.test.task.idflabtesttask.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import ru.alina.test.task.idflabtesttask.model.Currency;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;


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
    private OffsetDateTime dateTime;

    @JsonIgnore
    private LocalDateTime localDateTime;

    @JsonIgnore
    private ZoneOffset zoneOffset;

    private BigDecimal limitSum;

    private OffsetDateTime limitDatetime;

    @JsonIgnore
    private LocalDateTime limitLocalDateTime;

    @JsonIgnore
    private ZoneOffset limitZoneOffset;


    private Currency limitCurrency;

    public TransactionExceededLimitTo() {
        this.limitCurrency = Currency.USD;
    }


}

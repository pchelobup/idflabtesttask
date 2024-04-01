package ru.alina.test.task.idflabtesttask.to;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.alina.test.task.idflabtesttask.model.Currency;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Component
@Getter
@Setter
public class LimitToResponse {

    private LimitCategory category;

    private BigDecimal sum;

    private Currency currency;

    private OffsetDateTime datetime;

    public LimitToResponse() {
        this.currency = Currency.USD;
    }
}

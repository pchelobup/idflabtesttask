package ru.alina.test.task.idflabtesttask.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import ru.alina.test.task.idflabtesttask.exception.BadJsonParam;
import ru.alina.test.task.idflabtesttask.model.Currency;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
@Setter
@Getter
@NoArgsConstructor
@ToString
public class TransactionTo {
    @Min(value = 1000000000L)
    @Max(value = 9999999999L)
    private long accountFrom;


    @Min(value = 1000000000L)
    @Max(value = 9999999999L)
    private long accountTo;

    @NotNull
    private Currency currency;

    @NotNull
    @DecimalMin(value = "0.01")
    @Digits(integer=10, fraction=2)
    private BigDecimal sum;

    @NotNull
    private LimitCategory expenseCategory;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime datetime;


    @JsonIgnore
    private ZoneOffset zoneOffset;

    public void setAccountFrom(long accountFrom) {
        if(accountFrom>=1000000000L && accountFrom<10000000000L) {
            this.accountFrom = accountFrom;
        }
        else {
            throw new BadJsonParam("bad accountFrom");
        }


    }

    public void setAccountTo(long accountTo) {
        if(accountTo>=1000000000L && accountTo<10000000000L) {
            this.accountTo = accountFrom;
        }
        else {
            throw new BadJsonParam("bad accountFrom");
        }
    }
}

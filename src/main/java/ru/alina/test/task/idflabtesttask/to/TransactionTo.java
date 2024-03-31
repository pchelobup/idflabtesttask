package ru.alina.test.task.idflabtesttask.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import ru.alina.test.task.idflabtesttask.model.Currency;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
public class TransactionTo {

    @NotNull
    @Min(1000000000)
    @Max(9999999999L)
    private Long accountFrom;

    @NotNull
    @Min(1000000000)
    @Max(9999999999L)
    private Long accountTo;

    @NotNull
    private Currency currency;

    @NotNull
    private BigDecimal sum;

    @NotNull
    private LimitCategory expenseCategory;

    private OffsetDateTime datetime;

    @JsonIgnore
    private LocalDateTime localDateTime;

    @JsonIgnore
    private ZoneOffset zoneOffset;

    public long getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(long accountFrom) {
        this.accountFrom = accountFrom;
    }

    public long getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(long accountTo) {
        this.accountTo = accountTo;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public LimitCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(LimitCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public OffsetDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(OffsetDateTime datetime) {
        this.localDateTime = datetime.toLocalDateTime();
        this.zoneOffset = datetime.getOffset();
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public ZoneOffset getZoneOffset() {
        return zoneOffset;
    }

    public void setZoneOffset(ZoneOffset zoneOffset) {
        this.zoneOffset = zoneOffset;
    }

    @Override
    public String toString() {
        return "TransactionTo{" +
                "accountFrom=" + accountFrom +
                ", accountTo=" + accountTo +
                ", currency=" + currency +
                ", sum=" + sum +
                ", expenseCategory=" + expenseCategory +
                ", datetime=" + datetime +
                ", localDateTime=" + localDateTime +
                ", zoneOffset=" + zoneOffset +
                '}';
    }
}

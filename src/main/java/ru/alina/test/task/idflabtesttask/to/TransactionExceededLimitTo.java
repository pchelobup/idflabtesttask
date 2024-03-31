package ru.alina.test.task.idflabtesttask.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;
import ru.alina.test.task.idflabtesttask.model.Currency;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;


@Component
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

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(OffsetDateTime datetime) {
        this.dateTime = datetime;
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

    public BigDecimal getLimitSum() {
        return limitSum;
    }

    public void setLimitSum(BigDecimal limitSum) {
        this.limitSum = limitSum;
    }


    public LocalDateTime getLimitLocalDateTime() {
        return limitLocalDateTime;
    }

    public void setLimitLocalDateTime(LocalDateTime limitLocalDateTime) {
        this.limitLocalDateTime = limitLocalDateTime;
    }

    public ZoneOffset getLimitZoneOffset() {
        return limitZoneOffset;
    }

    public void setLimitZoneOffset(ZoneOffset limitZoneOffset) {
        this.limitZoneOffset = limitZoneOffset;
    }

    public OffsetDateTime getLimitDatetime() {
        return limitDatetime;
    }

    public void setLimitDatetime(OffsetDateTime limitDatetime) {
        this.limitDatetime = limitDatetime;
    }

    public Currency getLimitCurrency() {
        return limitCurrency;
    }

    public void setLimitCurrency(Currency limitCurrency) {
        this.limitCurrency = limitCurrency;
    }


    @Override
    public String toString() {
        return "TransactionExceededLimitTo{" +
                "accountFrom=" + accountFrom +
                ", accountTo=" + accountTo +
                ", currency=" + currency +
                ", sum=" + sum +
                ", expenseCategory=" + expenseCategory +
                ", dateTime=" + dateTime +
                ", localDateTime=" + localDateTime +
                ", zoneOffset=" + zoneOffset +
                ", limitSum=" + limitSum +
                ", limitLocalDateTime=" + limitLocalDateTime +
                ", limitZoneOffset=" + limitZoneOffset +
                ", limitCurrency=" + limitCurrency +
                '}';
    }
}

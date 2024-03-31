package ru.alina.test.task.idflabtesttask.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "limit_id")
    private Limit limit;
    private long accountFrom;
    private long accountTo;

    @Column(name = "currency_shortname")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    private BigDecimal sum;

    @Column(name = "sum_usd")
    private BigDecimal sumUSD;

    @Enumerated(EnumType.STRING)
    private LimitCategory expenseCategory;

    private LocalDateTime datetime;

    @Column(name = "zone_offset")
    private ZoneOffset zoneOffset;


    @Column(name = "limit_exceeded")
    private Boolean limitExceeded;

    public Transaction() {
    }

    public Transaction(Long id, long accountFrom, long accountTo, Currency currency, BigDecimal sum, BigDecimal sumUSD, LimitCategory expenseCategory, LocalDateTime datetime, ZoneOffset zoneOffset, Boolean limitExceeded) {
        super(id);
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.currency = currency;
        this.sum = sum;
        this.sumUSD = sumUSD;
        this.expenseCategory = expenseCategory;
        this.datetime = datetime;
        this.zoneOffset = zoneOffset;
        this.limitExceeded = limitExceeded;
    }

    public Limit getLimit() {
        return limit;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
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

    public BigDecimal getSumUSD() {
        return sumUSD;
    }

    public void setSumUSD(BigDecimal sumUSD) {
        this.sumUSD = sumUSD;
    }

    public LimitCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(LimitCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public ZoneOffset getZoneOffset() {
        return zoneOffset;
    }

    public void setZoneOffset(ZoneOffset zoneOffset) {
        this.zoneOffset = zoneOffset;
    }

    public Boolean getLimitExceeded() {
        return limitExceeded;
    }

    public void setLimitExceeded(Boolean limitExceeded) {
        this.limitExceeded = limitExceeded;
    }

    public boolean isLimitExceeded() {
        return limitExceeded;
    }

    public void setLimitExceeded(boolean limitExceeded) {
        this.limitExceeded = limitExceeded;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "limit=" + limit +
                ", accountFrom=" + accountFrom +
                ", accountTo=" + accountTo +
                ", currency=" + currency +
                ", sum=" + sum +
                ", sumUSD=" + sumUSD +
                ", expenseCategory=" + expenseCategory +
                ", datetime=" + datetime +
                ", zoneOffset=" + zoneOffset +
                ", limitExceeded=" + limitExceeded +
                ", id=" + id +
                '}';
    }
}

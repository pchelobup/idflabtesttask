package ru.alina.test.task.idflabtesttask.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.alina.test.task.idflabtesttask.exception.BadJsonParam;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
@Table(name = "transactions")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Transaction extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "limit_id")
    @ToString.Exclude
    private Limit limit;
    private Long accountFrom;
    private Long accountTo;

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

    public void setSum(BigDecimal sum) {
        if (sum.compareTo(BigDecimal.ZERO)<=0) {
            throw  new BadJsonParam("sum of transaction must be more than 0");
        }
        this.sum = sum;
    }
}

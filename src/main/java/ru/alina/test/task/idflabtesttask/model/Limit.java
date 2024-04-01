package ru.alina.test.task.idflabtesttask.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Entity
@Table(name = "limits")
@RequiredArgsConstructor
@Getter
@ToString
public class Limit extends BaseEntity {

    @Setter
    @Column(name = "limit_category")
    @Enumerated(EnumType.STRING)
    private LimitCategory category;

    @Column(name = "date_set_limit")
    private OffsetDateTime datetime;

    private BigDecimal sum;

    {
        this.datetime = OffsetDateTime.now(ZoneOffset.UTC);
    }


    public Limit(LimitCategory category) {
        this.category = category;
        this.sum = new BigDecimal("1000");
    }

    public Limit(Long id, LimitCategory category, OffsetDateTime date, BigDecimal sum) {
        super(id);
        this.category = category;
        this.datetime = date;
        setSum(sum);
    }


    public void setSum(BigDecimal sum) {
        if (sum == null || sum.compareTo(BigDecimal.ZERO) < 0) {
            this.sum = new BigDecimal("1000");
        } else {
            this.sum = sum;
        }

    }
}

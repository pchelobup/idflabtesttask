package ru.alina.test.task.idflabtesttask.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

//todo не должно быть сеттера на дату
@Entity
@Table(name = "limits")
@RequiredArgsConstructor
@Getter
@ToString
public class Limit extends BaseEntity {

    @Column(name = "limit_category")
    @Enumerated(EnumType.STRING)
    @Setter
    private LimitCategory category;

    @Column(name = "date_set_limit")
    @Setter
    private LocalDateTime dateTime;

    @Column(name = "zone_offset")
    @Setter
    private ZoneOffset zoneOffset;
    private BigDecimal sum;


    public Limit(LimitCategory category, ZoneOffset zoneOffset) {
        this.category = category;
        OffsetDateTime offsetDateTime = OffsetDateTime.now().withOffsetSameInstant(zoneOffset);
        this.dateTime = offsetDateTime.toLocalDateTime();
        this.zoneOffset = zoneOffset;
        this.sum = new BigDecimal("1000");

    }

    public Limit(Long id, LimitCategory category, LocalDateTime date, ZoneOffset zoneOffset, BigDecimal sum) {
        super(id);
        this.category = category;
        this.dateTime = date;
        this.zoneOffset = zoneOffset;
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

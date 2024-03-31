package ru.alina.test.task.idflabtesttask.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

//todo не должно быть сеттера на дату
@Entity
@Table(name = "limits")
public class Limit extends BaseEntity {

    @Column(name = "limit_category")
    @Enumerated(EnumType.STRING)
    private LimitCategory category;

    @Column(name = "date_set_limit")
    private LocalDateTime datetime;

    @Column(name = "zone_offset")
    private ZoneOffset zoneOffset;
    private BigDecimal sum;

    public Limit() {

    }

    public Limit(LimitCategory category, ZoneOffset zoneOffset) {
        this.category = category;
        OffsetDateTime offsetDateTime = OffsetDateTime.now().withOffsetSameInstant(zoneOffset);
        this.datetime = offsetDateTime.toLocalDateTime();
        this.zoneOffset = zoneOffset;
        this.sum = new BigDecimal("1000");

    }

    public Limit(Long id, LimitCategory category, LocalDateTime date, ZoneOffset zoneOffset, BigDecimal sum) {
        super(id);
        this.category = category;
        this.datetime = date;
        this.zoneOffset = zoneOffset;
        setSum(sum);
    }

    public LimitCategory getCategory() {
        return category;
    }

    public void setCategory(LimitCategory category) {
        this.category = category;
    }

    public LocalDateTime getDateTime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime dateTime) {
        this.datetime = dateTime;
    }

    public ZoneOffset getZoneOffset() {
        return zoneOffset;
    }

    public void setZoneOffset(ZoneOffset zoneOffset) {
        this.zoneOffset = zoneOffset;
    }

    public BigDecimal getSum() {
        return sum;
    }


    public void setSum(BigDecimal sum) {
        if (sum == null || sum.compareTo(BigDecimal.ZERO) < 0) {
            this.sum = new BigDecimal("1000");
        } else {
            this.sum = sum;
        }

    }

    @Override
    public String toString() {
        return "Limit{" +
                "category=" + category +
                ", date=" + datetime +
                ", sum=" + sum +
                ", id=" + id +
                '}';
    }
}

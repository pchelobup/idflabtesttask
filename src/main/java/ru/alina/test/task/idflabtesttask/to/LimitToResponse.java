package ru.alina.test.task.idflabtesttask.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import ru.alina.test.task.idflabtesttask.model.Currency;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
public class LimitToResponse {
    @NotNull
    private LimitCategory category;

    @NotNull
    private BigDecimal sum;

    @NotNull
    private Currency currency;

    @JsonIgnore
    private LocalDateTime localDateTime;

    @JsonIgnore
    private ZoneOffset zoneOffset;

    private OffsetDateTime datetime;

    public LimitToResponse() {
        currency = Currency.USD;
    }

    public LimitCategory getCategory() {
        return category;
    }

    public void setCategory(LimitCategory category) {
        this.category = category;
    }

    public BigDecimal getSum() {

        return sum;
    }

    public void setSum(BigDecimal sum) {

        this.sum = sum;
    }

    public Currency getCurrency() {
        return currency;
    }

    public OffsetDateTime getDatetime() {
        return datetime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void setZoneOffset(ZoneOffset zoneOffset) {
        this.zoneOffset = zoneOffset;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public ZoneOffset getZoneOffset() {
        return zoneOffset;
    }

    public void setDatetime(OffsetDateTime datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "LimitToResponse{" +
                "category=" + category +
                ", sum=" + sum +
                ", currency=" + currency +
                ", localDateTime=" + localDateTime +
                ", zoneOffset=" + zoneOffset +
                ", datetime=" + datetime +
                '}';
    }
}

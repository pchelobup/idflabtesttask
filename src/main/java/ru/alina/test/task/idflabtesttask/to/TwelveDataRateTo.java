package ru.alina.test.task.idflabtesttask.to;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TwelveDataRateTo {
    private BigDecimal close;

    private LocalDate timestamp;

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "TwelveDataRateTo{" +
                "close=" + close +
                ", timestamp=" + timestamp +
                '}';
    }
}

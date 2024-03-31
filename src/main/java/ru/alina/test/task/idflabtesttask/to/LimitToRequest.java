package ru.alina.test.task.idflabtesttask.to;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
public class LimitToRequest {

    @NotNull
    LimitCategory category;

    @NotNull
    BigDecimal sum;

    @NotNull
    ZoneOffset zoneOffset;

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


    public void setDatetime(OffsetDateTime datetime) {
        this.zoneOffset = datetime.getOffset();
    }


    public ZoneOffset getZoneOffset() {
        return zoneOffset;
    }

    public void setZoneOffset(ZoneOffset zoneOffset) {
        this.zoneOffset = zoneOffset;
    }
}

package ru.alina.test.task.idflabtesttask.to;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
@Getter
@Setter
@NoArgsConstructor
@ToString
public class LimitToRequest {

    @NotNull
    LimitCategory category;

    @NotNull
    BigDecimal sum;

    @NotNull
    ZoneOffset zoneOffset;



    public void setDatetime(OffsetDateTime datetime) {
        this.zoneOffset = datetime.getOffset();
    }


}

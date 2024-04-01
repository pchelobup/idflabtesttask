package ru.alina.test.task.idflabtesttask.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import ru.alina.test.task.idflabtesttask.model.Currency;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
@Setter
@Getter
@NoArgsConstructor
@ToString
public class TransactionTo {

    @NotNull
    @Min(1000000000)
    @Max(9999999999L)
    private Long accountFrom;

    @NotNull
    @Min(1000000000)
    @Max(9999999999L)
    private Long accountTo;

    @NotNull
    private Currency currency;

    @NotNull
    private BigDecimal sum;

    @NotNull
    private LimitCategory expenseCategory;

    private OffsetDateTime datetime;

    @JsonIgnore
    private LocalDateTime localDateTime;

    @JsonIgnore
    private ZoneOffset zoneOffset;


    public void setDatetime(OffsetDateTime datetime) {
        this.localDateTime = datetime.toLocalDateTime();
        this.zoneOffset = datetime.getOffset();
    }



}

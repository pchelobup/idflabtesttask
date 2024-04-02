package ru.alina.test.task.idflabtesttask.to;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.alina.test.task.idflabtesttask.exception.BadJsonParam;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;

import java.math.BigDecimal;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class LimitToRequest {
    @NotNull
    LimitCategory category;

    @DecimalMin(value = "0.01")
    @Digits(integer = 10, fraction = 2)
    @NotNull
    BigDecimal sum;

    public void setSum(BigDecimal sum) {
        if (sum.compareTo(BigDecimal.ZERO) < 0) {
            throw new BadJsonParam("sum must be 0 or bigger than 0");
        } else {
            this.sum = sum;
        }
    }
}

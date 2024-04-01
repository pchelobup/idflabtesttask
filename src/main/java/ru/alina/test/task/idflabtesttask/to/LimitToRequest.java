package ru.alina.test.task.idflabtesttask.to;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;

import java.math.BigDecimal;

@Component
@Getter
@Setter
@NoArgsConstructor
@ToString
public class LimitToRequest {
    @NotNull
    LimitCategory category;

    @DecimalMin(value = "0.01")
    @Digits(integer = 10, fraction = 2)
    @NotNull
    BigDecimal sum;

}

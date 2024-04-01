package ru.alina.test.task.idflabtesttask.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TwelveDataRateTo {
    private BigDecimal close;

    private LocalDate timestamp;

}

package ru.alina.test.task.idflabtesttask.web.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import ru.alina.test.task.idflabtesttask.exception.ExchangeRateClientException;
import ru.alina.test.task.idflabtesttask.model.ExchangeRate;
import ru.alina.test.task.idflabtesttask.to.TwelveDataRateTo;
import ru.alina.test.task.idflabtesttask.util.ExchangeRateUtil;
import ru.alina.test.task.idflabtesttask.model.Currency;

import java.time.Duration;
import java.util.Date;


@Service
public class ExchangeRatesClientService {
    @Value("${twelvedata.api.key}")
    public String apiKey;


    public ExchangeRate getExchangeRates(Date date, Currency currency) {
        WebClient webClient = WebClient.create();
        TwelveDataRateTo response = webClient.get()
                .uri(builder -> builder
                        .scheme("https").host("api.twelvedata.com").path("eod")
                        .queryParam("symbol", ExchangeRateUtil.getCurrencyPair(currency))
                        .queryParam("interval", "1day")
                        .queryParam("apikey", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(TwelveDataRateTo.class)
                .retryWhen(Retry.fixedDelay(3, Duration.ofMillis(100)))
                .onErrorResume(Exception.class, ex -> {
                    ex.printStackTrace();
                    return Mono.empty();
                })
                .block();
        if (response!=null && response.getClose()!=null) {
            return new ExchangeRate(date, currency, response.getClose());
        }
        else {
            throw new ExchangeRateClientException();
        }
    }
}

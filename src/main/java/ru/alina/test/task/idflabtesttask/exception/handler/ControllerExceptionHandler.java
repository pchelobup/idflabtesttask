package ru.alina.test.task.idflabtesttask.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import ru.alina.test.task.idflabtesttask.exception.ControllerErrorMessage;
import ru.alina.test.task.idflabtesttask.exception.ExchangeRateClientException;
import ru.alina.test.task.idflabtesttask.exception.InvalidCreated;

import java.util.Date;


@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = ExchangeRateClientException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> resourceNotFoundException(ExchangeRateClientException ex, WebRequest request) {
        ControllerErrorMessage message = new ControllerErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                request.getDescription(false),
                new Date());

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = InvalidCreated.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> resourceNotFoundException(InvalidCreated ex, WebRequest request) {
        ControllerErrorMessage message = new ControllerErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                request.getDescription(false),
                new Date());

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

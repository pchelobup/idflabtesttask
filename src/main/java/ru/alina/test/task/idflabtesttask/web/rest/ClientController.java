package ru.alina.test.task.idflabtesttask.web.rest;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alina.test.task.idflabtesttask.exception.InvalidCreated;
import ru.alina.test.task.idflabtesttask.mapper.LimitMapper;
import ru.alina.test.task.idflabtesttask.mapper.TransactionMapper;
import ru.alina.test.task.idflabtesttask.model.Limit;
import ru.alina.test.task.idflabtesttask.model.Transaction;
import ru.alina.test.task.idflabtesttask.service.LimitService;
import ru.alina.test.task.idflabtesttask.service.TransactionService;
import ru.alina.test.task.idflabtesttask.to.LimitToRequest;
import ru.alina.test.task.idflabtesttask.to.LimitToResponse;
import ru.alina.test.task.idflabtesttask.to.TransactionExceededLimitTo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/api/test-task-client")
public class ClientController {
    private static final Logger log = LoggerFactory.getLogger(ClientController.class);
    private final TransactionService transactionService;

    private final LimitService limitService;

    private TransactionMapper transactionMapper;

    private LimitMapper limitMapper;

    public ClientController(TransactionService transactionService, LimitService limitService, TransactionMapper transactionMapper, LimitMapper limitMapper) {
        this.transactionService = transactionService;
        this.limitService = limitService;
        this.transactionMapper = transactionMapper;
        this.limitMapper = limitMapper;
    }

    @GetMapping("/tr-exceed")
    public ResponseEntity<?> getExceededTransactions() {
        log.info("IN getExceededTransactions");
        List<Transaction> transaction = transactionService.getExceededLimitTransactions();
        List<TransactionExceededLimitTo> response = new ArrayList<>();

        transaction.forEach(t -> response.add(transactionMapper.limitExceededToToTransaction(t)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * устанвливает новый лимит
     * дата и время устанавливается автомотически в местном времени клиента
     *
     * @param limitTo
     */
    @PostMapping("/limit")
    @ResponseStatus(HttpStatus.CREATED)
    public void setLimit(@RequestBody @Valid LimitToRequest limitTo) {
        log.info("IN setLimit");
        Limit limit = limitMapper.requstLimitToLimit(limitTo);
        Limit created = limitService.save(limit);
        if (created==null) throw new InvalidCreated("invalid create limit");
    }

    @GetMapping("/limits")
    public ResponseEntity<?> getLimits() {
        log.info("IN getLimits");
        List<Limit> limits = limitService.getAll();
        List<LimitToResponse> response = new ArrayList<>();
        limits.forEach(l -> response.add(limitMapper.limitToResponse(l)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}

package ru.alina.test.task.idflabtesttask.web.rest;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.alina.test.task.idflabtesttask.exception.InvalidCreated;
import ru.alina.test.task.idflabtesttask.mapper.TransactionMapper;
import ru.alina.test.task.idflabtesttask.model.Transaction;
import ru.alina.test.task.idflabtesttask.service.TransactionService;
import ru.alina.test.task.idflabtesttask.to.TransactionTo;

@RestController
@RequestMapping("/v1/api/test-task-bank")
public class BankController {
    private static final Logger log = LoggerFactory.getLogger(BankController.class);
    private final TransactionService transactionService;

    private TransactionMapper transactionMapper;

    public BankController(TransactionService transactionService, TransactionMapper transactionMapper) {
        this.transactionService = transactionService;
        this.transactionMapper = transactionMapper;
    }

    @PostMapping("/tr")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTransaction(@RequestBody @Valid TransactionTo transactionTo) {
        log.info("IN saveTransaction");
        Transaction created = transactionService.save(transactionMapper.toToTransaction(transactionTo));
        if (created == null) throw new InvalidCreated("invalid created transaction");
    }
}

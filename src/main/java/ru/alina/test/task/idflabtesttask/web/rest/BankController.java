package ru.alina.test.task.idflabtesttask.web.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name="Контроллер для приема транзакций", description="Взаимодействие с банковским сервисом")
public class BankController {
    private static final Logger log = LoggerFactory.getLogger(BankController.class);
    private final TransactionService transactionService;

    private TransactionMapper transactionMapper;

    public BankController(TransactionService transactionService, TransactionMapper transactionMapper) {
        this.transactionService = transactionService;
        this.transactionMapper = transactionMapper;
    }

    @Operation(
            summary = "Сохранение транзакции",
            description = "Сохраняет полученную транзакцию и помечает транзакцию если месячный лимит исчерпан"
    )
    @PostMapping("/tr")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTransaction(@RequestBody @Valid TransactionTo transactionTo) {
        log.info("IN saveTransaction");
        Transaction created = transactionService.save(transactionMapper.toToTransaction(transactionTo));
        if (created == null) throw new InvalidCreated("invalid created transaction");
    }
}

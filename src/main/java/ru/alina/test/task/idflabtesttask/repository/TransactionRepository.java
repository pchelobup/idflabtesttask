package ru.alina.test.task.idflabtesttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;
import ru.alina.test.task.idflabtesttask.model.Transaction;

import java.time.OffsetDateTime;
import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT  t from Transaction t where t.expenseCategory=:category and  t.datetime BETWEEN :dateFrom AND :dateTo")
    List<Transaction> findAllByDatetime(LimitCategory category, @Param("dateFrom") OffsetDateTime dateFrom, @Param("dateTo") OffsetDateTime dateTo);

    @Query("SELECT  t from Transaction t join fetch t.limit l where t.limitExceeded=:exceed order by t.datetime desc")
    List<Transaction> getExceededLimitTransactions(boolean exceed);
}

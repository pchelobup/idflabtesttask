package ru.alina.test.task.idflabtesttask.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.alina.test.task.idflabtesttask.model.Limit;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;

import java.time.LocalDateTime;

public interface LimitRepository extends JpaRepository<Limit, Long> {

    @Query("SELECT l FROM Limit l WHERE l.category=:category and l.datetime>=:from and l.datetime<=:to order by l.datetime desc limit 1")
    Limit findLastMonthLimit(LocalDateTime from, LocalDateTime to, LimitCategory category);
}

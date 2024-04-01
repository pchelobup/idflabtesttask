package ru.alina.test.task.idflabtesttask.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import ru.alina.test.task.idflabtesttask.TimingExtension;

@ActiveProfiles("test")
@SpringBootTest
@Sql(scripts = {"classpath:static/db/initPostgres.sql", "classpath:static/db/populateTestDB.sql"}, config = @SqlConfig(encoding = "UTF-8"), executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ExtendWith(TimingExtension.class)
public abstract class ServiceTest {
}

package ru.alina.test.task.idflabtesttask.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alina.test.task.idflabtesttask.model.Limit;
import ru.alina.test.task.idflabtesttask.model.LimitCategory;
import ru.alina.test.task.idflabtesttask.repository.LimitRepository;
import ru.alina.test.task.idflabtesttask.service.LimitService;
import ru.alina.test.task.idflabtesttask.util.ValidationUtil;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class LimitServiceImpl implements LimitService {
    private static final Logger log = LoggerFactory.getLogger(LimitServiceImpl.class);
    private final LimitRepository limitRepository;

    public LimitServiceImpl(LimitRepository limitRepository) {
        this.limitRepository = limitRepository;
    }

    /**
     * @param category
     * @param date     дата, на снов месяца из это йдаты отдается последний установленный лимит в этом месяце
     *                 если лимит еще не был утсановленн но уставнливается в этой же транзакции в сумме 1000 USD
     * @return
     */
    @Override
    @Transactional
    public Limit getMonthLimit(LimitCategory category, LocalDateTime date, ZoneOffset zoneOffset) {
        LocalDateTime dateFrom = LocalDateTime.of(date.getYear(), date.getMonth(), 1, 0, 0);
        Limit limit = limitRepository.findLastMonthLimit(dateFrom, date, category);
        log.info("get limit {} IN getMonthLimit", limit);
        return limit == null ? save(new Limit(category, zoneOffset)) : limit;
    }

    @Override
    public List<Limit> getAll() {
        List<Limit> limits = limitRepository.findAll();
        log.info("get {} limits", limits.size());
        return limitRepository.findAll();
    }

    @Override
    @Transactional
    public Limit save(Limit limit) {
        ValidationUtil.checkNew(limit);
        Limit created = limitRepository.save(limit);
        log.info("create {}", created);
        return created;
    }


}

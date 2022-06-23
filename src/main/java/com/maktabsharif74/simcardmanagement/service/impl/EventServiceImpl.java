package com.maktabsharif74.simcardmanagement.service.impl;

import com.maktabsharif74.simcardmanagement.base.service.impl.BaseServiceImpl;
import com.maktabsharif74.simcardmanagement.domain.Event;
import com.maktabsharif74.simcardmanagement.repository.EventRepository;
import com.maktabsharif74.simcardmanagement.service.EventService;
import com.maktabsharif74.simcardmanagement.util.RandomUtil;

public class EventServiceImpl extends BaseServiceImpl<Event, Long, EventRepository> implements EventService {

    public EventServiceImpl(EventRepository repository) {
        super(repository);
    }

    @Override
    public Event save(Event event) {
        if (event.getId() == null) {
            setCode(event);
        }
        return super.save(event);
    }

    private void setCode(Event event) {
        String code = RandomUtil.getRandomNumeric(8);
        while (repository.existsByCode(code)) {
            code = RandomUtil.getRandomNumeric(8);
        }
        event.setCode(
                code
        );
    }
}

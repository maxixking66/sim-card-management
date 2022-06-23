package com.maktabsharif74.simcardmanagement.service.impl;

import com.maktabsharif74.simcardmanagement.base.service.impl.BaseServiceImpl;
import com.maktabsharif74.simcardmanagement.domain.Event;
import com.maktabsharif74.simcardmanagement.repository.EventRepository;
import com.maktabsharif74.simcardmanagement.service.EventService;

public class EventServiceImpl extends BaseServiceImpl<Event, Long, EventRepository> implements EventService {
    public EventServiceImpl(EventRepository repository) {
        super(repository);
    }
}

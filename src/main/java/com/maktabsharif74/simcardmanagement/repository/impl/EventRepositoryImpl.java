package com.maktabsharif74.simcardmanagement.repository.impl;

import com.maktabsharif74.simcardmanagement.base.repository.impl.BaseRepositoryImpl;
import com.maktabsharif74.simcardmanagement.domain.Event;
import com.maktabsharif74.simcardmanagement.repository.EventRepository;

import javax.persistence.EntityManager;

public class EventRepositoryImpl extends BaseRepositoryImpl<Event, Long> implements EventRepository {
    @Override
    public Class<Event> getEntityClass() {
        return Event.class;
    }

    public EventRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public boolean existsByCode(String code) {
        return entityManager.createQuery(
                "select (count(c.id) > 0) from Event c where c.code = :code",
                Boolean.class
        ).setParameter("code", code).getSingleResult();

    }
}

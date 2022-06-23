package com.maktabsharif74.simcardmanagement.repository.impl;

import com.maktabsharif74.simcardmanagement.base.repository.impl.BaseRepositoryImpl;
import com.maktabsharif74.simcardmanagement.domain.SimCard;
import com.maktabsharif74.simcardmanagement.repository.SimCardRepository;

import javax.persistence.EntityManager;

public class SimCardRepositoryImpl extends BaseRepositoryImpl<SimCard, Long>
        implements SimCardRepository {

    public SimCardRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<SimCard> getEntityClass() {
        return SimCard.class;
    }
}

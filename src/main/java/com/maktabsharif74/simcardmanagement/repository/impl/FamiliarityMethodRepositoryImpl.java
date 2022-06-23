package com.maktabsharif74.simcardmanagement.repository.impl;

import com.maktabsharif74.simcardmanagement.base.repository.impl.BaseRepositoryImpl;
import com.maktabsharif74.simcardmanagement.domain.FamiliarityMethod;
import com.maktabsharif74.simcardmanagement.repository.FamiliarityMethodRepository;

import javax.persistence.EntityManager;

public class FamiliarityMethodRepositoryImpl extends BaseRepositoryImpl<FamiliarityMethod, Long>
        implements FamiliarityMethodRepository {

    public FamiliarityMethodRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<FamiliarityMethod> getEntityClass() {
        return FamiliarityMethod.class;
    }
}

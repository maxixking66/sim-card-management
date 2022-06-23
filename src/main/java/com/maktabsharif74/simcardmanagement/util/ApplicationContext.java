package com.maktabsharif74.simcardmanagement.util;

import com.maktabsharif74.simcardmanagement.repository.FamiliarityMethodRepository;
import com.maktabsharif74.simcardmanagement.repository.impl.FamiliarityMethodRepositoryImpl;
import com.maktabsharif74.simcardmanagement.service.FamiliarityMethodService;
import com.maktabsharif74.simcardmanagement.service.impl.FamiliarityMethodServiceImpl;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();

    private static FamiliarityMethodRepository familiarityMethodRepository;

    private static FamiliarityMethodService familiarityMethodService;

    private ApplicationContext() {
    }

    public static FamiliarityMethodRepository getFamiliarityMethodRepository() {
        if (familiarityMethodRepository == null) {
            familiarityMethodRepository = new FamiliarityMethodRepositoryImpl(em);
        }
        return familiarityMethodRepository;
    }

    public static FamiliarityMethodService getFamiliarityMethodService() {
        if (familiarityMethodService == null) {
            familiarityMethodService = new FamiliarityMethodServiceImpl(getFamiliarityMethodRepository());
        }
        return familiarityMethodService;
    }
}
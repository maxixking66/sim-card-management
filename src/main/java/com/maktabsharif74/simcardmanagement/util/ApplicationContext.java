package com.maktabsharif74.simcardmanagement.util;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();

    private ApplicationContext() {
    }

}
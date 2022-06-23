package com.maktabsharif74.simcardmanagement;

import com.maktabsharif74.simcardmanagement.util.HibernateUtil;

import javax.persistence.EntityManager;

public class SimCardManagementApplication {

    public static void main(String[] args) {

        EntityManager entityManager =
                HibernateUtil.getEntityManagerFactory().createEntityManager();

    }
}

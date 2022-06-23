package com.maktabsharif74.simcardmanagement.repository.impl;

import com.maktabsharif74.simcardmanagement.base.repository.impl.BaseRepositoryImpl;
import com.maktabsharif74.simcardmanagement.domain.Customer;
import com.maktabsharif74.simcardmanagement.repository.CustomerRepository;

import javax.persistence.EntityManager;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Long>
        implements CustomerRepository {

    public CustomerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }

    @Override
    public boolean existsByCode(String code) {
        return entityManager.createQuery(
                "select (count(c.id) > 0) from Customer c where c.code = :code",
                Boolean.class
        ).setParameter("code", code).getSingleResult();

    }

    @Override
    public List<Customer> findAllByCreateDateLessThanEqual(ZonedDateTime createDate) {
        return entityManager.createQuery(
                "select c from Customer c where c.createDate <= :createDate",
                Customer.class
        ).setParameter("createDate", createDate).getResultList();
    }

    @Override
    public List<Customer> findAllByCreateDateLessThan(ZonedDateTime createDate) {
        return entityManager.createQuery(
                "select c from Customer c where c.createDate < :createDate",
                Customer.class
        ).setParameter("createDate", createDate).getResultList();
    }

    @Override
    public List<Customer> findAllByCreateDateGreaterThanEqual(ZonedDateTime createDate) {
        return entityManager.createQuery(
                "select c from Customer c where c.createDate >= :createDate",
                Customer.class
        ).setParameter("createDate", createDate).getResultList();
    }

    @Override
    public List<Customer> findAllByCreateDateGreaterThan(ZonedDateTime createDate) {
        new Date().after
        return entityManager.createQuery(
                "select c from Customer c where c.createDate > :createDate",
                Customer.class
        ).setParameter("createDate", createDate).getResultList();
    }

    @Override
    public List<Customer> findAllByCreateDateIsBetween(ZonedDateTime fromDate, ZonedDateTime toDate) {
        return entityManager.createQuery(
                        "select c from Customer c where c.createDate between :fromDate and :toDate",
                        Customer.class
                ).setParameter("fromDate", fromDate)
                .setParameter("toDate", toDate)
                .getResultList();
    }
}

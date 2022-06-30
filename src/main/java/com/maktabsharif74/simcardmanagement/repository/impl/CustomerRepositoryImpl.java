package com.maktabsharif74.simcardmanagement.repository.impl;

import com.maktabsharif74.simcardmanagement.base.repository.impl.BaseRepositoryImpl;
import com.maktabsharif74.simcardmanagement.domain.Customer;
import com.maktabsharif74.simcardmanagement.repository.CustomerRepository;
import com.maktabsharif74.simcardmanagement.service.dto.CustomerSearch;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.ZonedDateTime;
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

    @Override
    public List<Customer> findAll(CustomerSearch customerSearch) {
        String query = "select c from Customer c ";
        boolean isFirstWhereClause = true;

        if (customerSearch.getFirstName() != null && !customerSearch.getFirstName().isEmpty()) {
            isFirstWhereClause = false;
            query = query.concat("where c.firstName like :firstName ");
        }

        if (customerSearch.getLastName() != null && !customerSearch.getLastName().isEmpty()) {
            if (isFirstWhereClause) {
                isFirstWhereClause = false;
                query = query.concat("where c.lastName like :lastName ");
            } else {
                query = query.concat("and c.lastName like :lastName ");
            }
        }

        if (customerSearch.getUsername() != null && !customerSearch.getUsername().isEmpty()) {
            if (isFirstWhereClause) {
                isFirstWhereClause = false;
                query = query.concat("where c.username like :username ");
            } else {
                query = query.concat("and c.username like :username ");
            }
        }

        if (customerSearch.getCode() != null && !customerSearch.getCode().isEmpty()) {
            if (isFirstWhereClause) {
                isFirstWhereClause = false;
                query = query.concat("where c.code like :code ");
            } else {
                query = query.concat("and c.code like :code ");
            }
        }

        if (customerSearch.getFamiliarityMethodId() != null) {
            if (isFirstWhereClause) {
                isFirstWhereClause = false;
                query = query.concat("where c.familiarityMethod.id = :familiarityMethodId ");
            } else {
                query = query.concat("and c.familiarityMethod.id = :familiarityMethodId ");
            }
        }

        TypedQuery<Customer> typedQuery = entityManager.createQuery(query, Customer.class);

        if (customerSearch.getFirstName() != null && !customerSearch.getFirstName().isEmpty()) {
            typedQuery.setParameter("firstName", "%".concat(customerSearch.getFirstName()).concat("%"));
        }

        if (customerSearch.getLastName() != null && !customerSearch.getLastName().isEmpty()) {
            typedQuery.setParameter("lastName", "%".concat(customerSearch.getLastName()).concat("%"));
        }

        if (customerSearch.getUsername() != null && !customerSearch.getUsername().isEmpty()) {
            typedQuery.setParameter("username", "%".concat(customerSearch.getUsername()).concat("%"));
        }

        if (customerSearch.getCode() != null && !customerSearch.getCode().isEmpty()) {
            typedQuery.setParameter("code", "%".concat(customerSearch.getCode()).concat("%"));
        }

        if (customerSearch.getFamiliarityMethodId() != null) {
            typedQuery.setParameter("familiarityMethodId", customerSearch.getFamiliarityMethodId());
        }

        return typedQuery.getResultList();
    }
}

package com.maktabsharif74.simcardmanagement.repository.impl;

import com.maktabsharif74.simcardmanagement.base.repository.impl.BaseRepositoryImpl;
import com.maktabsharif74.simcardmanagement.domain.Customer;
import com.maktabsharif74.simcardmanagement.repository.CustomerRepository;

import javax.persistence.EntityManager;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Long>
        implements CustomerRepository {

    public CustomerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }
}

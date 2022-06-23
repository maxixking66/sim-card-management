package com.maktabsharif74.simcardmanagement.service.impl;

import com.maktabsharif74.simcardmanagement.base.service.impl.BaseServiceImpl;
import com.maktabsharif74.simcardmanagement.domain.Customer;
import com.maktabsharif74.simcardmanagement.repository.CustomerRepository;
import com.maktabsharif74.simcardmanagement.service.CustomerService;

public class CustomerServiceImpl
        extends BaseServiceImpl<Customer, Long, CustomerRepository>
        implements CustomerService {

    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }

}

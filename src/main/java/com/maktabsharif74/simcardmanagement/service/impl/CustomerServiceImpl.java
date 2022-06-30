package com.maktabsharif74.simcardmanagement.service.impl;

import com.maktabsharif74.simcardmanagement.base.service.impl.BaseServiceImpl;
import com.maktabsharif74.simcardmanagement.domain.Customer;
import com.maktabsharif74.simcardmanagement.repository.CustomerRepository;
import com.maktabsharif74.simcardmanagement.service.CustomerService;
import com.maktabsharif74.simcardmanagement.service.dto.CustomerSearch;
import com.maktabsharif74.simcardmanagement.util.RandomUtil;

import java.util.List;

public class CustomerServiceImpl
        extends BaseServiceImpl<Customer, Long, CustomerRepository>
        implements CustomerService {

    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }

    @Override
    public Customer save(Customer customer) {
        if (customer.getId() == null) {
            setCode(customer);
        }
        return super.save(customer);
    }

    private void setCode(Customer customer) {
        String code = RandomUtil.getRandomNumeric(8);
        while (repository.existsByCode(code)) {
            code = RandomUtil.getRandomNumeric(8);
        }
        customer.setCode(
                code
        );
    }

    @Override
    public List<Customer> findAll(CustomerSearch customerSearch) {
        if (customerSearch == null) {
            return repository.findAll();
        }
        return repository.findAll(customerSearch);
    }

    @Override
    public List<Customer> findAllWithCriteria(CustomerSearch customerSearch) {
        return repository.findAllWithCriteria(customerSearch);
    }
}

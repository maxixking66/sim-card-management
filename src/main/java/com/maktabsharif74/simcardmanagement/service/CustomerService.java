package com.maktabsharif74.simcardmanagement.service;

import com.maktabsharif74.simcardmanagement.base.service.BaseService;
import com.maktabsharif74.simcardmanagement.domain.Customer;
import com.maktabsharif74.simcardmanagement.service.dto.CustomerSearch;

import java.util.List;

public interface CustomerService extends BaseService<Customer, Long> {

    List<Customer> findAll(CustomerSearch customerSearch);

}

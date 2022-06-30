package com.maktabsharif74.simcardmanagement;

import com.maktabsharif74.simcardmanagement.domain.Customer;
import com.maktabsharif74.simcardmanagement.service.CustomerService;
import com.maktabsharif74.simcardmanagement.service.dto.CustomerSearch;
import com.maktabsharif74.simcardmanagement.util.ApplicationContext;

import java.util.List;

public class SimCardManagementApplication {

    public static void main(String[] args) {
        CustomerService customerService = ApplicationContext.getCustomerService();

        CustomerSearch customerSearch = new CustomerSearch();
        customerSearch.setCode("65");
        customerSearch.setFirstName("x");
        customerSearch.setFamiliarityMethodId(5L);


        List<Customer> customerList = customerService.findAll(customerSearch);
        if (customerList != null) {
            System.out.println(customerList);
        }

    }
}

package com.maktabsharif74.simcardmanagement;

import com.maktabsharif74.simcardmanagement.domain.Customer;
import com.maktabsharif74.simcardmanagement.service.CustomerService;
import com.maktabsharif74.simcardmanagement.util.ApplicationContext;

public class SimCardManagementApplication {

    public static void main(String[] args) {
        CustomerService customerService = ApplicationContext.getCustomerService();
        Customer customer = new Customer();
        customer.setFirstName("armin");
        customer.setLastName("aliani");
        customerService.save(customer);
    }
}

package com.maktabsharif74.simcardmanagement;

import com.maktabsharif74.simcardmanagement.repository.CustomerRepository;
import com.maktabsharif74.simcardmanagement.service.CustomerService;
import com.maktabsharif74.simcardmanagement.util.ApplicationContext;

import java.time.ZonedDateTime;

public class SimCardManagementApplication {

    public static void main(String[] args) {
        CustomerService customerService = ApplicationContext.getCustomerService();

        CustomerRepository customerRepository = ApplicationContext.getCustomerRepository();
        System.out.println("1: findAllByCreateDateLessThan");
        System.out.println(
                customerRepository.findAllByCreateDateLessThan(ZonedDateTime.now())
        );

        System.out.println("2: findAllByCreateDateGreaterThanEqual");
        System.out.println(
                customerRepository.findAllByCreateDateGreaterThanEqual(ZonedDateTime.now())
        );

        System.out.println("3: findAllByCreateDateGreaterThanEqual");
        System.out.println(
                customerRepository.findAllByCreateDateGreaterThanEqual(ZonedDateTime.now().minusHours(1).minusMinutes(30))
        );

        System.out.println("4: findAllByCreateDateIsBetween");
        System.out.println(
                customerRepository.findAllByCreateDateIsBetween(ZonedDateTime.now().minusHours(3), ZonedDateTime.now())
        );


    }
}

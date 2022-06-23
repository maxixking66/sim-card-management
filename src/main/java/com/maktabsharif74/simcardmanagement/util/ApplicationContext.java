package com.maktabsharif74.simcardmanagement.util;

import com.maktabsharif74.simcardmanagement.repository.AdminRepository;
import com.maktabsharif74.simcardmanagement.repository.CustomerRepository;
import com.maktabsharif74.simcardmanagement.repository.FamiliarityMethodRepository;
import com.maktabsharif74.simcardmanagement.repository.SimCardRepository;
import com.maktabsharif74.simcardmanagement.repository.impl.AdminRepositoryImpl;
import com.maktabsharif74.simcardmanagement.repository.impl.CustomerRepositoryImpl;
import com.maktabsharif74.simcardmanagement.repository.impl.FamiliarityMethodRepositoryImpl;
import com.maktabsharif74.simcardmanagement.repository.impl.SimCardRepositoryImpl;
import com.maktabsharif74.simcardmanagement.service.AdminService;
import com.maktabsharif74.simcardmanagement.service.CustomerService;
import com.maktabsharif74.simcardmanagement.service.FamiliarityMethodService;
import com.maktabsharif74.simcardmanagement.service.SimCardService;
import com.maktabsharif74.simcardmanagement.service.impl.AdminServiceImpl;
import com.maktabsharif74.simcardmanagement.service.impl.CustomerServiceImpl;
import com.maktabsharif74.simcardmanagement.service.impl.FamiliarityMethodServiceImpl;
import com.maktabsharif74.simcardmanagement.service.impl.SimCardServiceImpl;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();

    private static FamiliarityMethodRepository familiarityMethodRepository;

    private static FamiliarityMethodService familiarityMethodService;

    private static CustomerRepository customerRepository;

    private static CustomerService customerService;

    private static AdminRepository adminRepository;

    private static AdminService adminService;

    private static SimCardRepository simCardRepository;

    private static SimCardService simCardService;

    private ApplicationContext() {
    }

    public static FamiliarityMethodRepository getFamiliarityMethodRepository() {
        if (familiarityMethodRepository == null) {
            familiarityMethodRepository = new FamiliarityMethodRepositoryImpl(em);
        }
        return familiarityMethodRepository;
    }

    public static FamiliarityMethodService getFamiliarityMethodService() {
        if (familiarityMethodService == null) {
            familiarityMethodService = new FamiliarityMethodServiceImpl(getFamiliarityMethodRepository());
        }
        return familiarityMethodService;
    }

    public static CustomerRepository getCustomerRepository() {
        if (customerRepository == null) {
            customerRepository = new CustomerRepositoryImpl(em);
        }
        return customerRepository;
    }

    public static CustomerService getCustomerService() {
        if (customerService == null) {
            customerService = new CustomerServiceImpl(getCustomerRepository());
        }
        return customerService;
    }

    public static AdminRepository getAdminRepository() {
        if (adminRepository == null) {
            adminRepository = new AdminRepositoryImpl(em);
        }
        return adminRepository;
    }

    public static AdminService getAdminService() {
        if (adminService == null) {
            adminService = new AdminServiceImpl(getAdminRepository());
        }
        return adminService;
    }

    public static SimCardRepository getSimCardRepository() {
        if (simCardRepository == null) {
            simCardRepository = new SimCardRepositoryImpl(em);
        }
        return simCardRepository;
    }

    public static SimCardService getSimCardService() {
        if (simCardService == null) {
            simCardService = new SimCardServiceImpl(getSimCardRepository());
        }
        return simCardService;
    }
}
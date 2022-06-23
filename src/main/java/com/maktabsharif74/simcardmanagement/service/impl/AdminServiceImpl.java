package com.maktabsharif74.simcardmanagement.service.impl;

import com.maktabsharif74.simcardmanagement.base.service.impl.BaseServiceImpl;
import com.maktabsharif74.simcardmanagement.domain.Admin;
import com.maktabsharif74.simcardmanagement.repository.AdminRepository;
import com.maktabsharif74.simcardmanagement.service.AdminService;

public class AdminServiceImpl
        extends BaseServiceImpl<Admin, Long, AdminRepository>
        implements AdminService {

    public AdminServiceImpl(AdminRepository repository) {
        super(repository);
    }

}

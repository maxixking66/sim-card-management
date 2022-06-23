package com.maktabsharif74.simcardmanagement.service.impl;

import com.maktabsharif74.simcardmanagement.base.service.impl.BaseServiceImpl;
import com.maktabsharif74.simcardmanagement.domain.SimCard;
import com.maktabsharif74.simcardmanagement.repository.SimCardRepository;
import com.maktabsharif74.simcardmanagement.service.SimCardService;

public class SimCardServiceImpl
        extends BaseServiceImpl<SimCard, Long, SimCardRepository>
        implements SimCardService {

    public SimCardServiceImpl(SimCardRepository repository) {
        super(repository);
    }

}

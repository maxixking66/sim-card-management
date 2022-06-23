package com.maktabsharif74.simcardmanagement.service.impl;

import com.maktabsharif74.simcardmanagement.base.service.impl.BaseServiceImpl;
import com.maktabsharif74.simcardmanagement.domain.FamiliarityMethod;
import com.maktabsharif74.simcardmanagement.repository.FamiliarityMethodRepository;
import com.maktabsharif74.simcardmanagement.service.FamiliarityMethodService;

public class FamiliarityMethodServiceImpl
        extends BaseServiceImpl<FamiliarityMethod, Long, FamiliarityMethodRepository>
        implements FamiliarityMethodService {

    public FamiliarityMethodServiceImpl(FamiliarityMethodRepository repository) {
        super(repository);
    }

}

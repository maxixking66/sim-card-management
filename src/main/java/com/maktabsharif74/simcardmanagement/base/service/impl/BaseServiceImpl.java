package com.maktabsharif74.simcardmanagement.base.service.impl;

import com.maktabsharif74.simcardmanagement.base.domain.BaseEntity;
import com.maktabsharif74.simcardmanagement.base.repository.BaseRepository;
import com.maktabsharif74.simcardmanagement.base.service.BaseService;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl<E extends BaseEntity<ID>, ID extends Serializable,
        R extends BaseRepository<E, ID>> implements BaseService<E, ID> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E e) {
        try {
            repository.beginTransaction();
            e = repository.save(e);
            repository.commitTransaction();
            return e;
        } catch (Exception ex) {
            ex.printStackTrace();
            repository.rollbackTransaction();
            throw ex;
        }
    }

    @Override
    public E findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(ID id) {
        try {
            repository.beginTransaction();
            repository.deleteById(id);
            repository.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            repository.rollbackTransaction();
            throw e;
        }
    }

    @Override
    public long countAll() {
        return repository.countAll();
    }
}

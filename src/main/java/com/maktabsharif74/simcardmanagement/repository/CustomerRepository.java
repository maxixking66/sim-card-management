package com.maktabsharif74.simcardmanagement.repository;

import com.maktabsharif74.simcardmanagement.base.repository.BaseRepository;
import com.maktabsharif74.simcardmanagement.domain.Customer;
import com.maktabsharif74.simcardmanagement.service.dto.CustomerSearch;

import java.time.ZonedDateTime;
import java.util.List;

public interface CustomerRepository extends BaseRepository<Customer, Long> {

    boolean existsByCode(String code);

    List<Customer> findAllByCreateDateLessThanEqual(ZonedDateTime createDate);

    List<Customer> findAllByCreateDateLessThan(ZonedDateTime createDate);

    List<Customer> findAllByCreateDateGreaterThanEqual(ZonedDateTime createDate);

    List<Customer> findAllByCreateDateGreaterThan(ZonedDateTime createDate);

    List<Customer> findAllByCreateDateIsBetween(ZonedDateTime fromDate, ZonedDateTime toDate);

    List<Customer> findAll(CustomerSearch customerSearch);

    List<Customer> findAllWithCriteria(CustomerSearch customerSearch);
}

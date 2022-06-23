package com.maktabsharif74.simcardmanagement.domain;

import com.maktabsharif74.simcardmanagement.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.ZonedDateTime;

@Entity
public class Event extends BaseEntity<Long> {
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private SimCard simCard;
    private ZonedDateTime createDate=ZonedDateTime.now();
    @Column(length = 1024)
    private String description;

}

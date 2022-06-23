package com.maktabsharif74.simcardmanagement.domain;

import com.maktabsharif74.simcardmanagement.base.domain.BaseEntity;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = Event.TABLE_NAME)
public class Event extends BaseEntity<Long> {

    public static final String TABLE_NAME = "event";

    public static final String CUSTOMER_ID = "customer_id";
    public static final String SIM_CARD_ID = "sim_card_id";
    public static final String CREATE_DATE = "create_date";
    public static final String DESCRIPTION = "description";
    public static final String CODE = "code";

    @ManyToOne
    @JoinColumn(name = CUSTOMER_ID)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = SIM_CARD_ID)
    private SimCard simCard;

    @Column(name = CREATE_DATE)
    private ZonedDateTime createDate;

    @Column(name = DESCRIPTION)
    @Lob
    private String description;

    @Column(name = CODE)
    private String code;

    public Event() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SimCard getSimCard() {
        return simCard;
    }

    public void setSimCard(SimCard simCard) {
        this.simCard = simCard;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

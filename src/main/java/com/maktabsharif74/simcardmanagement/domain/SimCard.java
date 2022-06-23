package com.maktabsharif74.simcardmanagement.domain;

import com.maktabsharif74.simcardmanagement.base.domain.BaseEntity;
import com.maktabsharif74.simcardmanagement.domain.enumeration.OperatorType;
import com.maktabsharif74.simcardmanagement.domain.enumeration.RondType;
import com.maktabsharif74.simcardmanagement.domain.enumeration.SimCardStatus;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = SimCard.TABLE_NAME)
public class SimCard extends BaseEntity<Long> {

    public static final String TABLE_NAME = "sim_card";

    public static final String CREATE_DATE = "create_date";
    public static final String LAST_UPDATE_DATE = "last_update_date";
    public static final String CUSTOMER_ID = "customer_id";
    public static final String SIM_CARD_NUMBER = "sim_card_number";
    public static final String CUSTOM_STYLE_NUMBER = "custom_style_number";
    public static final String OPERATOR_TYPE = "operator_type";
    public static final String STATUS = "status";
    public static final String SIM_CARD_RONDS = "sim_card_ronds";
    public static final String SIM_CARD_ID = "sim_card_id";
    public static final String MIN_PRICE = "min_price";
    public static final String MAX_PRICE = "max_price";

    @Column(name = CREATE_DATE)
    private ZonedDateTime createDate = ZonedDateTime.now();

    @Column(name = LAST_UPDATE_DATE)
    private ZonedDateTime lastUpdateDate;

    @ManyToOne
    @JoinColumn(name = CUSTOMER_ID)
    private Customer customer;

    @Column(name = SIM_CARD_NUMBER)
    private String simCardNumber;

    @Column(name = CUSTOM_STYLE_NUMBER)
    private String customStyleNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = OPERATOR_TYPE)
    private OperatorType operatorType;

    @Enumerated(EnumType.STRING)
    @Column(name = STATUS)
    private SimCardStatus status;

    @ElementCollection
    @CollectionTable(name = SIM_CARD_RONDS, joinColumns = @JoinColumn(name = SIM_CARD_ID))
    private Set<RondType> rondTypes = new HashSet<>();

    @Column(name = MIN_PRICE)
    private Long minPrice;

    @Column(name = MAX_PRICE)
    private Long maxPrice;

    public SimCard() {
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public ZonedDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(ZonedDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getSimCardNumber() {
        return simCardNumber;
    }

    public void setSimCardNumber(String simCardNumber) {
        this.simCardNumber = simCardNumber;
    }

    public String getCustomStyleNumber() {
        return customStyleNumber;
    }

    public void setCustomStyleNumber(String customStyleNumber) {
        this.customStyleNumber = customStyleNumber;
    }

    public OperatorType getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(OperatorType operatorType) {
        this.operatorType = operatorType;
    }

    public SimCardStatus getStatus() {
        return status;
    }

    public void setStatus(SimCardStatus status) {
        this.status = status;
    }

    public Set<RondType> getRondTypes() {
        return rondTypes;
    }

    public void setRondTypes(Set<RondType> rondTypes) {
        this.rondTypes = rondTypes;
    }

    public Long getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Long minPrice) {
        this.minPrice = minPrice;
    }

    public Long getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Long maxPrice) {
        this.maxPrice = maxPrice;
    }
}

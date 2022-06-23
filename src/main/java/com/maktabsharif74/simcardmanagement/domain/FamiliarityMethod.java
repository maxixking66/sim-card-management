package com.maktabsharif74.simcardmanagement.domain;

import com.maktabsharif74.simcardmanagement.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Table(name = FamiliarityMethod.TABLE_NAME)
public class FamiliarityMethod extends BaseEntity<Long> {

    public static final String TABLE_NAME = "familiarity_method";

    public static final String NAME = "name";
    public static final String CREATE_DATE = "create_date";

    @Column(name = NAME)
    private String name;

    @Column(name = CREATE_DATE)
    private ZonedDateTime createDate = ZonedDateTime.now();

    public FamiliarityMethod() {
    }

    public FamiliarityMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }
}

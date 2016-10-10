package com.frame.commons.entity;

import com.frame.commons.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by THINK on 2016/9/28.
 */

@Entity
@Table(name = "MI_ADDRESS")
public class Address extends BaseEntity {

    private String addrName;

    private Integer level;

    public String getAddrName() {
        return addrName;
    }

    public void setAddrName(String addrName) {
        this.addrName = addrName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}

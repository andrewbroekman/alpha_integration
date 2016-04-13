package com.codinginfinity.research.people;

import com.codinginfinity.research.core.BaseEntity;

/**
 * Created by andrew on 2016/04/11.
 */
public class EmailAddress extends BaseEntity{

    private static final long serialVersionUID = -3722133432195112178L;

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

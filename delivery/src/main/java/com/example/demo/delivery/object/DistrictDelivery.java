package com.example.demo.delivery.object;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class DistrictDelivery implements Serializable {

    private int district;
    private long orderid;

    public DistrictDelivery() {
    }

    public DistrictDelivery(int district, long orderid) {
        this.district = district;
        this.orderid = orderid;
    }
}
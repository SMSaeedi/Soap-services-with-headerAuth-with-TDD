package com.example.demo.delivery.object;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class OrderLine implements Serializable {

    private long ol_supply_w_id;
    private long ol_i_id;
    private long ol_quantity;
    private double ol_amount;
    private Date ol_delivery_d;

    public OrderLine() {
    }

    public OrderLine(long ol_supply_w_id, long ol_i_id, long ol_quantity, double ol_amount, Date ol_delivery_d) {
        this.ol_supply_w_id = ol_supply_w_id;
        this.ol_i_id = ol_i_id;
        this.ol_quantity = ol_quantity;
        this.ol_amount = ol_amount;
        this.ol_delivery_d = ol_delivery_d;
    }
}
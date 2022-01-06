package com.example.demo.delivery.object;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class Order implements Serializable {

    private long o_id;
    private String c_id;
    private Date entdate;
    private long o_carrier_id;
    private List<OrderLine> orderLines;

    public Order() {
    }

    public Order(long o_id, String c_id, Date entdate, long o_carrier_id, List<OrderLine> orderLines) {
        this.o_id = o_id;
        this.c_id = c_id;
        this.entdate = entdate;
        this.o_carrier_id = o_carrier_id;
        this.orderLines = orderLines;
    }
}
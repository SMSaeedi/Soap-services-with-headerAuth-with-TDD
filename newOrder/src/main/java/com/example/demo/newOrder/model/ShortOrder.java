package com.example.demo.newOrder.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class ShortOrder implements Serializable {

    private long o_id;
    private double total_amount;
    private String errMsg;

    public ShortOrder() {
    }

    public ShortOrder(long o_id, double total_amount) {
        this.o_id = o_id;
        this.total_amount = total_amount;
    }
}
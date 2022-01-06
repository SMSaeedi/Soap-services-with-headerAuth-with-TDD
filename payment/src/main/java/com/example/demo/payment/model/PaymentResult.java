package com.example.demo.payment.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class PaymentResult implements Serializable {

    private String w_id;
    private String errMsg;
    private String w_street_1;
    private String w_street_2;
    private String w_city;
    private String w_state;
    private String w_zip;
    private String d_id;
    private String d_street_1;
    private String d_street_2;
    private String d_city;
    private String d_state;
    private String d_zip;
    private String c_id;
    private String c_first;
    private String c_middle;
    private String c_last;
    private String c_street_1;
    private String c_street_2;
    private String c_city;
    private String c_state;
    private String c_zip;
    private Date c_since;
    private String c_credit;
    private double c_discount;
    private String c_phone;
    private double h_amount;
    private double c_credit_lim;
    private double c_balance;
    private String c_data;

    public PaymentResult() {
    }
    public PaymentResult(String w_city, String w_state, String w_zip, String d_id, String d_city, String d_state, String d_zip, String c_id) {
        this.w_city = w_city;
        this.w_state = w_state;
        this.w_zip = w_zip;
        this.d_id = d_id;
        this.d_city = d_city;
        this.d_state = d_state;
        this.d_zip = d_zip;
        this.c_id = c_id;
    }

    public PaymentResult(String w_id, String w_street_1, String w_street_2, String w_city, String w_state, String w_zip, String d_id, String d_street_1, String d_street_2, String d_city, String d_state, String d_zip, String c_id, String c_first, String c_middle, String c_last, String c_street_1, String c_street_2, String c_city, String c_state, String c_zip, Date c_since, String c_credit, double c_discount, String c_phone, double h_amount, double c_credit_lim, double c_balance, String c_data) {
        this.w_id = w_id;
        this.w_street_1 = w_street_1;
        this.w_street_2 = w_street_2;
        this.w_city = w_city;
        this.w_state = w_state;
        this.w_zip = w_zip;
        this.d_id = d_id;
        this.d_street_1 = d_street_1;
        this.d_street_2 = d_street_2;
        this.d_city = d_city;
        this.d_state = d_state;
        this.d_zip = d_zip;
        this.c_id = c_id;
        this.c_first = c_first;
        this.c_middle = c_middle;
        this.c_last = c_last;
        this.c_street_1 = c_street_1;
        this.c_street_2 = c_street_2;
        this.c_city = c_city;
        this.c_state = c_state;
        this.c_zip = c_zip;
        this.c_since = c_since;
        this.c_credit = c_credit;
        this.c_discount = c_discount;
        this.c_phone = c_phone;
        this.h_amount = h_amount;
        this.c_credit_lim = c_credit_lim;
        this.c_balance = c_balance;
        this.c_data = c_data;
    }
}
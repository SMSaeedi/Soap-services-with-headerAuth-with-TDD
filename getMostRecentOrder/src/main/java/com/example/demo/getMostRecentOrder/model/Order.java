package com.example.demo.getMostRecentOrder.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class Order implements Serializable {

    public Order() {
        order_lines = new ArrayList<OrderLine>();
    }

    public Order(String c_fname, String c_lname, String o_ship_type, String o_status) {
        this.c_fname = c_fname;
        this.c_lname = c_lname;
        this.o_ship_type = o_ship_type;
        this.o_status = o_status;
    }

    public Order(ResultSet rs) {
        this();
        try {
            o_id = rs.getInt("o_id");
            c_fname = rs.getString("c_fname");
            c_lname = rs.getString("c_lname");
            c_passwd = rs.getString("c_passwd");
            c_uname = rs.getString("c_uname");
            c_phone = rs.getString("c_phone");
            c_email = rs.getString("c_email");
            o_date = rs.getDate("o_date");
            o_subtotal = rs.getDouble("o_sub_total");
            o_tax = rs.getDouble("o_tax");
            o_total = rs.getDouble("o_total");
            o_ship_type = rs.getString("o_ship_type");
            o_ship_date = rs.getDate("o_ship_date");
            o_status = rs.getString("o_status");
            cx_type = rs.getString("cx_type");
            bill_addr_street1 = rs.getString("bill_addr_street1");
            bill_addr_street2 = rs.getString("bill_addr_street2");
            bill_addr_state = rs.getString("bill_addr_state");
            bill_addr_zip = rs.getString("bill_addr_zip");
            bill_co_name = rs.getString("bill_co_name");
            ship_addr_street1 = rs.getString("ship_addr_street1");
            ship_addr_street2 = rs.getString("ship_addr_street2");
            ship_addr_state = rs.getString("ship_addr_state");
            ship_addr_zip = rs.getString("ship_addr_zip");
            ship_co_name = rs.getString("ship_co_name");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int o_id;
    public String c_fname;
    public String c_lname;
    public String c_passwd;
    public String c_uname;
    public String c_phone;
    public String c_email;
    public Date o_date;
    public double o_subtotal;
    public double o_tax;
    public double o_total;
    public String o_ship_type;
    public Date o_ship_date;
    public String o_status;
    public String bill_addr_street1;
    public String bill_addr_street2;
    public String bill_addr_state;
    public String bill_addr_zip;
    public String bill_co_name;
    public String ship_addr_street1;
    public String ship_addr_street2;
    public String ship_addr_state;
    public String ship_addr_zip;
    public String ship_co_name;
    public String cx_type;
    public List<OrderLine> order_lines;
}
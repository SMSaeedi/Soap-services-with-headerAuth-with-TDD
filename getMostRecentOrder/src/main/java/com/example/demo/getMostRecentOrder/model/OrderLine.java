package com.example.demo.getMostRecentOrder.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.ResultSet;

@Setter
@Getter
@ToString
public class OrderLine implements Serializable {

    public OrderLine() {
    }

    public OrderLine(ResultSet rs) {
        try {
            ol_i_id = rs.getInt("ol_i_id");
            i_title = rs.getString("i_title");
            i_publisher = rs.getString("i_publisher");
            i_cost = rs.getDouble("i_cost");
            ol_qty = rs.getInt("ol_qty");
            ol_discount = rs.getDouble("ol_discount");
            ol_comments = rs.getString("ol_comments");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int ol_i_id;
    public String i_title;
    public String i_publisher;
    public double i_cost;
    public int ol_qty;
    public double ol_discount;
    public String ol_comments;
}
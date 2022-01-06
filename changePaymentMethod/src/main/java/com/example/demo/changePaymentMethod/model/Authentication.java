package com.example.demo.changePaymentMethod.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Authentication {

    private Integer errorCode = 0;
    private String user;
    private String password;

    public void setNullParams() {
        this.setUser("");
        this.setPassword("");
    }
}
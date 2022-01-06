package com.example.demo.getPassword.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Authentication {

    private Integer errorCode = 0;
    private String msg;
    private String user;
    private String token;
    private String password;
    private String errorMsg;
    private String expiredDate;

    public Authentication(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Authentication() {
    }

    public void setNullParams(){
        this.setUser("");
        this.setToken("");
        this.setPassword("");
        this.setMsg("");
        this.setExpiredDate("");
        this.setErrorMsg("Wrong userName or password");
    }

    public void setNullParams1(){
        this.setPassword("");
        this.setErrorMsg("");
        this.setExpiredDate("10 minutes");
        this.setMsg("Operation successfully done");
    }
}
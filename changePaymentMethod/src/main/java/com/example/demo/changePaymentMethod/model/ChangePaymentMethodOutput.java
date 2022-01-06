package com.example.demo.changePaymentMethod.model;

public class ChangePaymentMethodOutput {

    private String currPaymentMethod;
    private String errMsg;

    public String getCurrPaymentMethod() {
        return currPaymentMethod;
    }

    public void setCurrPaymentMethod(String currPaymentMethod) {
        this.currPaymentMethod = currPaymentMethod;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "ChangePaymentMethodOutput{" +
                "currPaymentMethod='" + currPaymentMethod + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
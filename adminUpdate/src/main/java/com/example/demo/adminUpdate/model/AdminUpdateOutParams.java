package com.example.demo.adminUpdate.model;

import java.util.ArrayList;
import java.util.List;

public class AdminUpdateOutParams {

    List<AdminUpdateInParams> setList = new ArrayList();
private String errMsg;

    public List<AdminUpdateInParams> getSetList() {
        return setList;
    }

    public void setSetList(List<AdminUpdateInParams> setList) {
        this.setList = setList;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public AdminUpdateOutParams() {
    }

    @Override
    public String toString() {
        return "AdminUpdateOutParams{" +
                "setList=" + setList +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
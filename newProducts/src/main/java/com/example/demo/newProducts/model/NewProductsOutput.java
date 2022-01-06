package com.example.demo.newProducts.model;

import java.util.List;

public class NewProductsOutput {

    List<NewProduct> newProductsList;
    private String errMsg;

    public NewProductsOutput() {
        super();
    }

    public List<NewProduct> getNewProductsList() {
        return newProductsList;
    }

    public void setNewProductsList(List<NewProduct> newProductsList) {
        this.newProductsList = newProductsList;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}

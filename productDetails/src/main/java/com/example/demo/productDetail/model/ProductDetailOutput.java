package com.example.demo.productDetail.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
public class ProductDetailOutput {

    private String message;
    private List<ProductDetailPojo> detailedProductsList = new ArrayList<>();

    public ProductDetailOutput() {
        super();
    }

}
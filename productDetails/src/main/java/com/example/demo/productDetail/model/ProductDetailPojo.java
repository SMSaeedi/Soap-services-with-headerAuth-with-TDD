package com.example.demo.productDetail.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class ProductDetailPojo {

    private Long itemId;
    private String itemTitle;
    private String authorFName;
    private String authorLName;
    private Date itemPubDate;
    private String itemPublisher;
    private String itemSubject;
    private String itemDesc;
    private String itemCost;
    private String itemSrp;
    private String itemAvail;
    private String itemIsbn;
    private String itemPage;
    private String itemBacking;
    private String itemDimensions;
    private byte[] imageBytes;
    private String emptyList;

}
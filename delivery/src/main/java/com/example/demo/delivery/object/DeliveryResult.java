package com.example.demo.delivery.object;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class DeliveryResult implements Serializable {

    private String w_id;
    private String o_carrier_id;
    private String errMsg;
    private int skippedDeliveries;
    private List<DistrictDelivery> districtDeliveryList;

    public DeliveryResult() {
    }

    public DeliveryResult(String w_id, String o_carrier_id, int skippedDeliveries, List<DistrictDelivery> districtDeliveryList) {
        this.w_id = w_id;
        this.o_carrier_id = o_carrier_id;
        this.skippedDeliveries = skippedDeliveries;
        this.districtDeliveryList = districtDeliveryList;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
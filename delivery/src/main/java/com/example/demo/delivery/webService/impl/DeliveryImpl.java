package com.example.demo.delivery.webService.impl;

import com.example.demo.delivery.model.*;
import com.example.demo.delivery.object.DeliveryResult;
import com.example.demo.delivery.webService.Delivery;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "Delivery")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class DeliveryImpl implements Delivery {

    @Resource
    WebServiceContext wsContext;

    @Override
    public DeliveryResult deliveryTransaction_Vx0(String w_id,String o_carrier_id) {
        Authentication outValues = new Authentication();
        DeliveryResult serviceOut = new DeliveryResult();

        try {
            outValues = getHttpHeaders(wsContext);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        if (outValues.getErrorCode() == 0)
            new Delivery_Vx0().deliveryTransactionTest(w_id, o_carrier_id);
        else {
            System.out.println("failed to call Delivery_Vx0().deliveryTransactionTest ");
            serviceOut.setErrMsg("Empty or wrong user/pass");
        }

        return serviceOut;
    }

    static Authentication getHttpHeaders(WebServiceContext wsContext) {
        Authentication user = new Authentication();
        MessageContext mctx = wsContext.getMessageContext();
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);

        List name = (List) http_headers.get("username");
        List pass = (List) http_headers.get("password");

        if (name == null || pass == null) {
            user.setNullParams();
            user.setErrorCode(1);
            return user;
        } else {
            String username = (String) name.get(0);
            String password = (String) pass.get(0);

            user.setUser(username);
            user.setPassword(password);
            return user;
        }
    }

    @Override
    public DeliveryResult deliveryTransaction_VxA(DeliveryResult input) {
        return new Delivery_VxA().deliveryTransaction(input.getW_id(), input.getO_carrier_id());
    }

    @Override
    public DeliveryResult deliveryTransaction_Vx051(DeliveryResult input) {
        return new Delivery_Vx051().deliveryTransaction(input.getW_id(), input.getO_carrier_id());
    }

    @Override
    public DeliveryResult deliveryTransaction_Vx075(DeliveryResult input) {
        return new Delivery_Vx075().deliveryTransaction(input.getW_id(), input.getO_carrier_id());
    }

    @Override
    public DeliveryResult deliveryTransaction_Vx099(DeliveryResult input) {
        return new Delivery_Vx099().deliveryTransaction(input.getW_id(), input.getO_carrier_id());
    }

    @Override
    public DeliveryResult deliveryTransaction_Vx123(DeliveryResult input) {
        return new Delivery_Vx123().deliveryTransaction(input.getW_id(), input.getO_carrier_id());
    }

    @Override
    public DeliveryResult deliveryTransaction_Vx138(DeliveryResult input) {
        return new Delivery_Vx138().deliveryTransaction(input.getW_id(), input.getO_carrier_id());
    }

    @Override
    public DeliveryResult deliveryTransaction_Vx154(DeliveryResult input) {
        return new Delivery_Vx154().deliveryTransaction(input.getW_id(), input.getO_carrier_id());
    }

    @Override
    public DeliveryResult deliveryTransaction_Vx176(DeliveryResult input) {
        return new Delivery_Vx176().deliveryTransaction(input.getW_id(), input.getO_carrier_id());
    }
}
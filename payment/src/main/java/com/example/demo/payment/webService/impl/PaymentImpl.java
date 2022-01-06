package com.example.demo.payment.webService.impl;

import com.example.demo.payment.model.*;
import com.example.demo.payment.webService.Payment;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "Payment")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class PaymentImpl implements Payment {

    @Resource
    WebServiceContext wsContext;

    @Override
    public PaymentResult paymentTransaction_Vx0(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name) {
        Authentication outValues = new Authentication();
        PaymentResult serviceOut = new PaymentResult();

        try {
            outValues = getHttpHeaders(wsContext);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        if (outValues.getErrorCode() == 0)
            serviceOut = new Payment_Vx0().paymentTransaction(w_id, c_w_id, h_amount, d_id, c_d_id, c_id, c_last, c_by_name);
        else {
            System.out.println("failed to call Payment_Vx0().paymentTransaction ");
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
    public PaymentResult paymentTransaction_Vx0Test() {
        return new Payment_Vx0().paymentTransactionTest();
    }


    @Override
    public PaymentResult paymentTransaction_VxA(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name) {
        return new Payment_VxA().paymentTransaction(w_id, c_w_id, h_amount, d_id, c_d_id, c_id, c_last, c_by_name);
    }

    @Override
    public PaymentResult paymentTransaction_Vx043(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name) {
        return new Payment_Vx043().paymentTransaction(w_id, c_w_id, h_amount, d_id, c_d_id, c_id, c_last, c_by_name);
    }

    @Override
    public PaymentResult paymentTransaction_Vx057(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name) {
        return new Payment_Vx057().paymentTransaction(w_id, c_w_id, h_amount, d_id, c_d_id, c_id, c_last, c_by_name);
    }

    @Override
    public PaymentResult paymentTransaction_Vx078(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name) {
        return new Payment_Vx078().paymentTransaction(w_id, c_w_id, h_amount, d_id, c_d_id, c_id, c_last, c_by_name);
    }

    @Override
    public PaymentResult paymentTransaction_Vx091(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name) {
        return new Payment_Vx091().paymentTransaction(w_id, c_w_id, h_amount, d_id, c_d_id, c_id, c_last, c_by_name);
    }

    @Override
    public PaymentResult paymentTransaction_Vx115(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name) {
        return new Payment_Vx115().paymentTransaction(w_id, c_w_id, h_amount, d_id, c_d_id, c_id, c_last, c_by_name);
    }

    @Override
    public PaymentResult paymentTransaction_Vx136(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name) {
        return new Payment_Vx136().paymentTransaction(w_id, c_w_id, h_amount, d_id, c_d_id, c_id, c_last, c_by_name);
    }

    @Override
    public PaymentResult paymentTransaction_Vx177(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name) {
        return new Payment_Vx177().paymentTransaction(w_id, c_w_id, h_amount, d_id, c_d_id, c_id, c_last, c_by_name);
    }

    @Override
    public PaymentResult paymentTransaction_Vx212(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name) {
        return new Payment_Vx212().paymentTransaction(w_id, c_w_id, h_amount, d_id, c_d_id, c_id, c_last, c_by_name);
    }

    @Override
    public PaymentResult paymentTransaction_Vx241(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name) {
        return new Payment_Vx241().paymentTransaction(w_id, c_w_id, h_amount, d_id, c_d_id, c_id, c_last, c_by_name);
    }

    @Override
    public PaymentResult paymentTransaction_Vx257(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name) {
        return new Payment_Vx257().paymentTransaction(w_id, c_w_id, h_amount, d_id, c_d_id, c_id, c_last, c_by_name);
    }

    @Override
    public PaymentResult paymentTransaction_Vx290(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name) {
        return new Payment_Vx290().paymentTransaction(w_id, c_w_id, h_amount, d_id, c_d_id, c_id, c_last, c_by_name);
    }
}

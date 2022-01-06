package com.example.demo.payment.webService;

import com.example.demo.payment.model.PaymentResult;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "http://impl.webService.payment.demo.example.com/")
public interface Payment {

    @WebMethod(operationName = "paymentTransaction_Vx0")
    public PaymentResult paymentTransaction_Vx0(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name);

    @WebMethod(operationName = "paymentTransaction_Vx0Test")
    public PaymentResult paymentTransaction_Vx0Test();

    @WebMethod(operationName = "paymentTransaction_VxA")
    public PaymentResult paymentTransaction_VxA(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name);

    @WebMethod(operationName = "paymentTransaction_Vx043")
    public PaymentResult paymentTransaction_Vx043(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name);

    @WebMethod(operationName = "paymentTransaction_Vx057")
    public PaymentResult paymentTransaction_Vx057(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name);

    @WebMethod(operationName = "paymentTransaction_Vx078")
    public PaymentResult paymentTransaction_Vx078(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name);

    @WebMethod(operationName = "paymentTransaction_Vx091")
    public PaymentResult paymentTransaction_Vx091(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name);

    @WebMethod(operationName = "paymentTransaction_Vx115")
    public PaymentResult paymentTransaction_Vx115(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name);

    @WebMethod(operationName = "paymentTransaction_Vx136")
    public PaymentResult paymentTransaction_Vx136(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name);

    @WebMethod(operationName = "paymentTransaction_Vx177")
    public PaymentResult paymentTransaction_Vx177(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name);

    @WebMethod(operationName = "paymentTransaction_Vx212")
    public PaymentResult paymentTransaction_Vx212(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name);

    @WebMethod(operationName = "paymentTransaction_Vx241")
    public PaymentResult paymentTransaction_Vx241(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name);

    @WebMethod(operationName = "paymentTransaction_Vx257")
    public PaymentResult paymentTransaction_Vx257(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name);

    @WebMethod(operationName = "paymentTransaction_Vx290")
    public PaymentResult paymentTransaction_Vx290(String w_id, String c_w_id, double h_amount, String d_id, String c_d_id, String c_id, String c_last, boolean c_by_name);

}
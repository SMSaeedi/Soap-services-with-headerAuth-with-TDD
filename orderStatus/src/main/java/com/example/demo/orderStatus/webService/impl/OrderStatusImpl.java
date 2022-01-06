package com.example.demo.orderStatus.webService.impl;

import com.example.demo.orderStatus.model.*;
import com.example.demo.orderStatus.webService.OrderStatus;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "OrderStatus")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class OrderStatusImpl implements OrderStatus {

    public static String userName = new String();

    @Resource
    WebServiceContext wsContext;

    @Override
    public Order orderStatusTransaction_Vx0(String w_id, String d_id, String c_id, String c_last, boolean c_by_name) throws SQLException {
        Authentication outValues = new Authentication();
        Order serviceOut = new Order();

        try {
            outValues = getHttpHeaders(wsContext);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        if (outValues.getErrorCode() == 0)
            serviceOut = new OrderStatus_Vx066().orderStatusTransaction(w_id, d_id, c_id, c_last, c_by_name);
        else {
            System.out.println("failed to call OrderStatus_Vx066().orderStatusTransaction ");
        }

        return serviceOut;
    }

    @Override
    public Order orderStatusTransaction_VxA(String w_id, String d_id, String c_id, String c_last, boolean c_by_name) throws SQLException {
        return new OrderStatus_Vx096().orderStatusTransaction(w_id, d_id, c_id, c_last, c_by_name);
    }

    @Override
    public Order orderStatusTransaction_Vx046(String w_id, String d_id, String c_id, String c_last, boolean c_by_name) throws Exception {
        return new OrderStatus_Vx046().orderStatusTransaction(w_id, d_id, c_id, c_last, c_by_name);
    }

    @Override
    public Order orderStatusTransaction_Vx066(String w_id, String d_id, String c_id, String c_last, boolean c_by_name) throws Exception {
        return new OrderStatus_Vx066().orderStatusTransaction(w_id, d_id, c_id, c_last, c_by_name);
    }

    @Override
    public Order orderStatusTransaction_Vx096(String w_id, String d_id, String c_id, String c_last, boolean c_by_name) throws Exception {
        return new OrderStatus_Vx096().orderStatusTransaction(w_id, d_id, c_id, c_last, c_by_name);
    }

 @Override
    public Order orderStatusTransaction_Vx122(String w_id, String d_id, String c_id, String c_last, boolean c_by_name) throws Exception {
        return new OrderStatus_Vx122().orderStatusTransaction(w_id, d_id, c_id, c_last, c_by_name);
    }

    @Override
    public Order orderStatusTransaction_Vx143(String w_id, String d_id, String c_id, String c_last, boolean c_by_name) throws Exception {
        return new OrderStatus_Vx143().orderStatusTransaction(w_id, d_id, c_id, c_last, c_by_name);
    }

    static Authentication getHttpHeaders(WebServiceContext wsContext) {
        Authentication user = new Authentication();
        MessageContext mctx = wsContext.getMessageContext();
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);

        List name = (List) http_headers.get("username");
        List Pass = (List) http_headers.get("Password");

        if (name == null || name.size() == 0 || Pass == null || Pass.size() == 0) {
            user.setErrorMsg("Incorrect user or pass");
            user.setNullParams();
            return null;
        } else {
            String username = (String) name.get(0);
            String password = (String) Pass.get(0);

            user.setUser(username);
            userName = username;
            user.setPassword(password);
            return user;
        }
    }
}
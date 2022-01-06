package com.example.demo.newOrder.webService.impl;

import com.example.demo.newOrder.model.*;
import com.example.demo.newOrder.webService.NewOrder;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "NewOrder")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class NewOrderImpl implements NewOrder {

    public static String userName = new String();

    @Resource
    WebServiceContext wsContext;

    @Override
    public ShortOrder newOrderTransaction_Vx0(String w_id, String d_id, String c_id, int o_ol_cnt, int o_all_local, long[] itemIDs, long[] supplierWarehouseIDs, long[] orderQuantities) {
        Authentication outValues = new Authentication();
        ShortOrder serviceOut = new ShortOrder();

        try {
            outValues = getHttpHeaders(wsContext);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        if (outValues.getErrorCode() == 0)
            serviceOut = new NewOrder_Vx0().newOrderTransaction(w_id, d_id, c_id, o_ol_cnt, o_all_local, itemIDs, supplierWarehouseIDs, orderQuantities);
        else {
            System.out.println("failed to call NewOrder_Vx0().newOrderTransaction ");
            serviceOut.setErrMsg("Empty or wrong user/pass");
        }

        return serviceOut;
    }

    @Override
    public ShortOrder newOrderTransaction_VxA(String w_id, String d_id, String c_id, int o_ol_cnt, int o_all_local, NewOrderLongList itemIDs, NewOrderLongList supplierWarehouseIDs, NewOrderLongList orderQuantities) {
        Authentication authOut;
        authOut = getHttpHeaders(wsContext);
        if (authOut.getErrorMsg() == "")
            return new NewOrder_VxA().newOrderTransaction(w_id, d_id, c_id, o_ol_cnt, o_all_local, itemIDs.longList, supplierWarehouseIDs.longList, orderQuantities.longList);
        else
            return null;
    }

    @Override
    public ShortOrder newOrderTransaction_Vx056(String w_id, String d_id, String c_id, int o_ol_cnt, int o_all_local, NewOrderLongList itemIDs, NewOrderLongList supplierWarehouseIDs, NewOrderLongList orderQuantities) {
        Authentication authOut;
        authOut = getHttpHeaders(wsContext);
        if (authOut.getErrorMsg() == "")
            return new NewOrder_Vx056().newOrderTransaction(w_id, d_id, c_id, o_ol_cnt, o_all_local, itemIDs.longList, supplierWarehouseIDs.longList, orderQuantities.longList);
        else
            return null;
    }

    @Override
    public ShortOrder newOrderTransaction_Vx081(String w_id, String d_id, String c_id, int o_ol_cnt, int o_all_local, NewOrderLongList itemIDs, NewOrderLongList supplierWarehouseIDs, NewOrderLongList orderQuantities) {
        Authentication authOut;
        authOut = getHttpHeaders(wsContext);
        if (authOut.getErrorMsg() == "")
            return new NewOrder_Vx081().newOrderTransaction(w_id, d_id, c_id, o_ol_cnt, o_all_local, itemIDs.longList, supplierWarehouseIDs.longList, orderQuantities.longList);
        else
            return null;
    }

    @Override
    public ShortOrder newOrderTransaction_Vx103(String w_id, String d_id, String c_id, int o_ol_cnt, int o_all_local, NewOrderLongList itemIDs, NewOrderLongList supplierWarehouseIDs, NewOrderLongList orderQuantities) {
        Authentication authOut;
        authOut = getHttpHeaders(wsContext);
        if (authOut.getErrorMsg() == "")
            return new NewOrder_Vx103().newOrderTransaction(w_id, d_id, c_id, o_ol_cnt, o_all_local, itemIDs.longList, supplierWarehouseIDs.longList, orderQuantities.longList);
        else
            return null;
    }

    @Override
    public ShortOrder newOrderTransaction_Vx119(String w_id, String d_id, String c_id, int o_ol_cnt, int o_all_local, NewOrderLongList itemIDs, NewOrderLongList supplierWarehouseIDs, NewOrderLongList orderQuantities) {
        Authentication authOut;
        authOut = getHttpHeaders(wsContext);
        if (authOut.getErrorMsg() == "")
            return new NewOrder_Vx119().newOrderTransaction(w_id, d_id, c_id, o_ol_cnt, o_all_local, itemIDs.longList, supplierWarehouseIDs.longList, orderQuantities.longList);
        else
            return null;
    }

    @Override
    public ShortOrder newOrderTransaction_Vx144(String w_id, String d_id, String c_id, int o_ol_cnt, int o_all_local, NewOrderLongList itemIDs, NewOrderLongList supplierWarehouseIDs, NewOrderLongList orderQuantities) {
        Authentication authOut;
        authOut = getHttpHeaders(wsContext);
        if (authOut.getErrorMsg() == "")
            return new NewOrder_Vx144().newOrderTransaction(w_id, d_id, c_id, o_ol_cnt, o_all_local, itemIDs.longList, supplierWarehouseIDs.longList, orderQuantities.longList);
        else
            return null;
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
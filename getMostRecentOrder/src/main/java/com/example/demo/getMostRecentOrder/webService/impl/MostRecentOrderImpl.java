package com.example.demo.getMostRecentOrder.webService.impl;

import com.example.demo.getMostRecentOrder.model.Authentication;
import com.example.demo.getMostRecentOrder.model.GetMostRecentOrder_Vx0;
import com.example.demo.getMostRecentOrder.model.GetMostRecentOrder_VxA;
import com.example.demo.getMostRecentOrder.model.Order;
import com.example.demo.getMostRecentOrder.webService.MostRecentOrder;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "MostRecentOrder")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class MostRecentOrderImpl implements MostRecentOrder {

    public static String userName = new String();

    @Resource
    WebServiceContext wsContext;

   @Override
    public Order getMostRecentOrder_Vx0(String c_uname) {
        return new GetMostRecentOrder_Vx0().getMostRecentOrder(c_uname);
    }

    @Override
    public Order getMostRecentOrder_VxA(String c_uname) {
        return new GetMostRecentOrder_VxA().getMostRecentOrder(c_uname);
    }

    @Override
    public Order getMostRecentOrder_Vx0Test(String c_uname) {
        return new GetMostRecentOrder_Vx0().getMostRecentOrderTest(c_uname);
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
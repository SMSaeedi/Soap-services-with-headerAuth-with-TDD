package com.example.demo.createShoppingCart.webService.impl;

import com.example.demo.createShoppingCart.model.Authentication;
import com.example.demo.createShoppingCart.model.Cart;
import com.example.demo.createShoppingCart.model.CreateShoppingCart_Vx0;
import com.example.demo.createShoppingCart.model.CreateShoppingCart_VxA;
import com.example.demo.createShoppingCart.webService.CreateShoppingCart;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "CreateShoppingCart")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class CreateShoppingCartImpl implements CreateShoppingCart {

    @Resource
    WebServiceContext wsContext;

    @Override
    public Cart createShoppingCart_Vx0(Integer I_ID, List<String> ids, List<String> quantities, Integer SHOPPING_ID) {
        Authentication outValues = new Authentication();
        Cart serviceOut = new Cart();

        try {
            outValues = getHttpHeaders(wsContext);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        if (outValues.getErrorCode() == 0)
            serviceOut =  new CreateShoppingCart_Vx0().createShoppingCart(I_ID, ids, quantities, SHOPPING_ID);
        else {
            System.out.println("failed to call CreateShoppingCart_Vx0().createShoppingCart ");
            serviceOut.setErrMsg("Empty or wrong user/pass");
        }

        return serviceOut;
    }

    @Override
    public Cart createShoppingCart_VxA(Integer I_ID, List<String> ids, List<String> quantities, Integer SHOPPING_ID) {
        return new CreateShoppingCart_VxA().createShoppingCart(I_ID, ids, quantities, SHOPPING_ID);
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
}
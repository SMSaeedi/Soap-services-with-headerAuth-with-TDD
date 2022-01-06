package com.example.demo.newProducts.webService.impl;

import com.example.demo.newProducts.model.*;
import com.example.demo.newProducts.webService.NewProduct;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "NewProducts")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class NewProductImpl implements NewProduct {

    @Resource
    WebServiceContext wsContext;

    @Override
    public NewProductsOutput newProducts_Vx0(NewProductsInput input) throws Exception {
        Authentication outValues = new Authentication();
        NewProductsOutput serviceOut = new NewProductsOutput();

        try {
            outValues = getHttpHeaders(wsContext);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        if (outValues.getErrorCode() == 0)
            serviceOut = new NewProducts_Vx0().process(input);
        else {
            System.out.println("failed to call NewProducts_Vx0().process " + input);
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
    public NewProductsOutput newProducts_VxA(NewProductsInput input) throws Exception {
        return new NewProducts_VxA().process(input);
    }
}
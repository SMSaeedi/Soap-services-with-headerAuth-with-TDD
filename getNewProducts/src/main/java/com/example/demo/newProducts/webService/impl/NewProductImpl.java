package com.example.demo.newProducts.webService.impl;

import com.example.demo.newProducts.model.Authentication;
import com.example.demo.newProducts.model.GetNewProducts_Vx0;
import com.example.demo.newProducts.model.GetNewProducts_VxA;
import com.example.demo.newProducts.model.ShortBook;
import com.example.demo.newProducts.webService.NewProduct;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "NewProduct")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class NewProductImpl implements NewProduct {

    @Resource
    WebServiceContext wsContext;

    @Override
    public List<ShortBook> getNewProducts_Vx0(String subject) {
        return new GetNewProducts_Vx0().getNewProducts(subject);
    }

    @Override
    public List<ShortBook> getNewProducts_Vx0Test(String subject) {
        Authentication outValues = new Authentication();
        List<ShortBook> serviceOut = new ArrayList<>();

        try {
            outValues = getHttpHeaders(wsContext);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        if (outValues.getErrorCode() == 0)
            serviceOut = new GetNewProducts_Vx0().getNewProductsTest(subject);
        else {
            System.out.println("failed to call GetNewProducts_Vx0().getNewProductsTest ");
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
    public List<ShortBook> getNewProducts_VxA(String subject) {
        return new GetNewProducts_VxA().getNewProducts(subject);
    }
}
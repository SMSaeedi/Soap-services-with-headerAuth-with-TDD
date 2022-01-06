package com.example.demo.getCustomer.webService.impl;

import com.example.demo.getCustomer.model.Authentication;
import com.example.demo.getCustomer.model.Customer;
import com.example.demo.getCustomer.model.GetCustomer_Vx0;
import com.example.demo.getCustomer.model.GetCustomer_VxA;
import com.example.demo.getCustomer.webService.GetCustomer;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "GetCustomer")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class GetCustomerImpl implements GetCustomer {

    @Resource
    WebServiceContext wsContext;

    @Override
    public Customer getCustomer_Vx0(String UNAME) {
        return new GetCustomer_Vx0().getCustomer(UNAME);
    }

    @Override
    public Customer getCustomer_Vx0Test(Customer uname) {
        Authentication outValues = new Authentication();
        Customer serviceOut = new Customer();

        try {
            outValues = getHttpHeaders(wsContext);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        if (outValues.getErrorCode() == 0)
            serviceOut = new GetCustomer_Vx0().getCustomerTest(uname);
        else {
            System.out.println("failed to call GetCustomer_Vx0().getCustomerTest ");
            serviceOut.errMsg = "Empty or wrong user/pass";
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
    public Customer getCustomer_VxA(String UNAME) {
        return new GetCustomer_VxA().getCustomer(UNAME);
    }
}
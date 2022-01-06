package com.example.demo.createNewCustomer.webService.impl;

import com.example.demo.createNewCustomer.webService.CreateNewCustomerService;
import com.example.demo.createNewCustomer.model.*;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "CreateCustomer")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class CreateNewCustomerServiceImpl implements CreateNewCustomerService {

    @Resource
    WebServiceContext wsContext;

    @Override
    public Customer createNewCustomer_Vx0(Customer input) {
        Authentication outValues = new Authentication();
        Customer serviceOut = new Customer();

        try {
            outValues = getHttpHeaders(wsContext);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        if (outValues.getErrorCode() == 0)
            serviceOut = new CreateNewCustomer_Vx0().createNewCustomerTest(input);
        else {
            System.out.println("failed to call CreateNewCustomer_Vx0().createNewCustomerTest " + input);
            serviceOut.setErrMsg("Empty or wrong user/pass");
        }

        return serviceOut;
    }

    @Override
    public Customer createNewCustomer_VxA(@WebParam(name = "cust") Customer cust) {
        return new CreateNewCustomer_VxA().createNewCustomer(cust);
    }

    @Override
    public Customer createNewCustomer_Vx078(@WebParam(name = "cust") Customer cust) {
        return new CreateNewCustomer_Vx078().createNewCustomer(cust);
    }

    @Override
    public Customer createNewCustomer_Vx103(@WebParam(name = "cust") Customer cust) {
        return new CreateNewCustomer_Vx103().createNewCustomer(cust);
    }

    @Override
    public Customer createNewCustomer_Vx113(@WebParam(name = "cust") Customer cust) {
        return new CreateNewCustomer_Vx113().createNewCustomer(cust);
    }

    @Override
    public Customer createNewCustomer_Vx132(@WebParam(name = "cust") Customer cust) {
        return new CreateNewCustomer_Vx132().createNewCustomer(cust);
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
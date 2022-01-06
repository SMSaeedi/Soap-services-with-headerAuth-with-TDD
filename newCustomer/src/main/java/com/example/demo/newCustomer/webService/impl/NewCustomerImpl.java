package com.example.demo.newCustomer.webService.impl;

import com.example.demo.newCustomer.model.*;
import com.example.demo.newCustomer.webService.NewCustomer;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "NewCustomer")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class NewCustomerImpl implements NewCustomer {

    @Resource
    WebServiceContext wsContext;

    @Override
    public NewCustomerOutput createNewCustomer_Vx0(NewCustomerInput input) {
        Authentication outValues = new Authentication();
        NewCustomerOutput serviceOut = new NewCustomerOutput();

        try {
            outValues = getHttpHeaders(wsContext);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        if (outValues.getErrorCode() == 0)
            serviceOut = new CreateNewCustomer_Vx0().test(input);
        else {
            System.out.println("failed to call AdminUpdate_Vx0().hardCodeData " + input);
            serviceOut.setErrMsg("Empty or wrong user/pass");
        }

        return serviceOut;
    }

    @Override
    public Customer createNewCustomer_VxA(Customer cust) {
        Authentication authOut;
        authOut = getHttpHeaders(wsContext);
        if (authOut.getErrorMsg() == "")
            return new CreateNewCustomer_VxA().createNewCustomer(cust);
        else
            return null;
    }

    @Override
    public Customer createNewCustomer_Vx078(Customer cust) {
        Authentication authOut;
        authOut = getHttpHeaders(wsContext);
        if (authOut.getErrorMsg() == "")
            return new CreateNewCustomer_Vx078().createNewCustomer(cust);
        else
            return null;
    }

    @Override
    public Customer createNewCustomer_Vx103(Customer cust) {
        Authentication authOut;
        authOut = getHttpHeaders(wsContext);
        if (authOut.getErrorMsg() == "")
            return new CreateNewCustomer_Vx103().createNewCustomer(cust);
        else
            return null;
    }

    @Override
    public Customer createNewCustomer_Vx113(Customer cust) {
        Authentication authOut;
        authOut = getHttpHeaders(wsContext);
        if (authOut.getErrorMsg() == "")
            return new CreateNewCustomer_Vx113().createNewCustomer(cust);
        else
            return null;
    }

    @Override
    public Customer createNewCustomer_Vx132(Customer cust) {
        Authentication authOut;
        authOut = getHttpHeaders(wsContext);
        if (authOut.getErrorMsg() == "")
            return new CreateNewCustomer_Vx132().createNewCustomer(cust);
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
            user.setPassword(password);
            return user;
        }
    }
}
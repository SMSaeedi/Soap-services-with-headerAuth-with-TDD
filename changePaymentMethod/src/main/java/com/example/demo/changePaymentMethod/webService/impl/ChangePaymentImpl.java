package com.example.demo.changePaymentMethod.webService.impl;

import com.example.demo.changePaymentMethod.model.*;
import com.example.demo.changePaymentMethod.webService.ChangePayment;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "ChangePayment")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class ChangePaymentImpl implements ChangePayment {

    @Resource
    WebServiceContext wsContext;

    @Override
    public ChangePaymentMethodOutput changePaymentMethod_Vx0(ChangePaymentMethodInput input) throws Exception {
        return new ChangePaymentMethod_Vx0().process(input);
    }

    @Override
    public ChangePaymentMethodOutput changePaymentMethod_VxA(ChangePaymentMethodInput input) throws Exception {
        return new ChangePaymentMethod_VxA().process(input);
    }

    @Override
    public ChangePaymentMethodOutput changePaymentMethod_test(ChangePaymentMethodInput input) {
        Authentication outValues = new Authentication();
        ChangePaymentMethodOutput serviceOut = new ChangePaymentMethodOutput();

        try {
            outValues = getHttpHeaders(wsContext);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        if (outValues.getErrorCode() == 0)
            serviceOut = new ChangePaymentMethod_VxA().hardCodeData(input);
        else {
            System.out.println("failed to call ChangePaymentMethod_VxA().hardCodeData " + input);
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
}
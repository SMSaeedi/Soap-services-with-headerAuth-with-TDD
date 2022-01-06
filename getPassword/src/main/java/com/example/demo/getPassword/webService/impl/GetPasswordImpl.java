package com.example.demo.getPassword.webService.impl;

import com.example.demo.getPassword.model.Authentication;
import com.example.demo.getPassword.model.GetPassword_Vx0;
import com.example.demo.getPassword.model.GetPassword_VxA;
import com.example.demo.getPassword.webService.GetPassword;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "GetPassword")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class GetPasswordImpl implements GetPassword {

    public static String userName = new String();

    @Resource
    WebServiceContext wsContext;

    @Override
    public String getPassword_Vx0(String C_UNAME) {
        return new GetPassword_Vx0().getPassword(C_UNAME);
    }

    @Override
    public String getPassword_VxA(String C_UNAME) {
        return new GetPassword_VxA().getPassword(C_UNAME);
    }

    @Override
    public String getPassword_Vx0Test(String C_UNAME) {
        Authentication outValues = new Authentication();
        String serviceOut = null;

        try {
            outValues = getHttpHeaders(wsContext);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        if (outValues.getErrorCode() == 0)
             serviceOut = new GetPassword_Vx0().getPasswordTest(C_UNAME);
        else {
            System.out.println("failed to call GetPassword_Vx0().getPasswordTest ");
        }

        return serviceOut;
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